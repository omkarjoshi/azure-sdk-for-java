/**
 *
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 *
 */

package com.microsoft.azure.management.network.samples;

import com.microsoft.azure.Azure;
import com.microsoft.azure.management.compute.KnownWindowsVirtualMachineImage;
import com.microsoft.azure.management.compute.VirtualMachine;
import com.microsoft.azure.management.compute.implementation.api.VirtualMachineSizeTypes;
import com.microsoft.azure.management.network.NetworkInterface;
import com.microsoft.azure.management.network.PublicIpAddress;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.azure.management.resources.fluentcore.utils.ResourceNamer;
import com.microsoft.azure.management.samples.Utils;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.File;
import java.util.Date;

/**
 * Azure Network sample for managing IP address -
 *  - Assign a public IP address for a virtual machine during its creation
 *  - Assign a public IP address for a virtual machine through an virtual machine update action
 *  - Get the associated public IP address for a virtual machine
 *  - Get the assigned public IP address for a virtual machine
 *  - Remove a public IP address from a virtual machine.
 */
public final class ManageIPAddress {

    /**
     * Main entry point.
     * @param args the parameters
     */
    public static void main(String[] args) {
        final String publicIpAddressName1 = ResourceNamer.randomResourceName("pip1", 20);
        final String publicIpAddressName2 = ResourceNamer.randomResourceName("pip2", 20);
        final String publicIpAddressLeafDNS1 = ResourceNamer.randomResourceName("pip1", 20);
        final String publicIpAddressLeafDNS2 = ResourceNamer.randomResourceName("pip2", 20);
        final String vmName = ResourceNamer.randomResourceName("vm", 8);
        final String rgName = ResourceNamer.randomResourceName("rgNEMPIP", 24);
        final String userName = "tirekicker";
        final String password = "12NewPA$$w0rd!";
        try {

            //=============================================================
            // Authenticate

            final File credFile = new File("my.azureauth");

            Azure azure = Azure
                    .configure()
                    .withLogLevel(HttpLoggingInterceptor.Level.BASIC)
                    .authenticate(credFile)
                    .withDefaultSubscription();

            // Print selected subscription
            System.out.println("Selected subscription: " + azure.subscriptionId());
            try {
                //============================================================
                // Assign a public IP address for a VM during its creation

                // Define a public Ip address to be used during VM creation time

                System.out.println("Creating a public Ip address...");

                PublicIpAddress publicIpAddress = azure.publicIpAddresses()
                        .define(publicIpAddressName1)
                        .withRegion(Region.US_EAST)
                        .withNewGroup(rgName)
                        .withLeafDomainLabel(publicIpAddressLeafDNS1)
                        .create();
                // Print public Ip address details
                Utils.print(publicIpAddress);

                // Use the pre-created public Ip for the new VM

                System.out.println("Creating a Windows VM");

                Date t1 = new Date();

                VirtualMachine vm = azure.virtualMachines().define(vmName)
                        .withRegion(Region.US_EAST)
                        .withExistingGroup(rgName)
                        .withNewPrimaryNetwork("10.0.0.0/28")
                        .withPrimaryPrivateIpAddressDynamic()
                        .withExistingPrimaryPublicIpAddress(publicIpAddress)
                        .withPopularWindowsImage(KnownWindowsVirtualMachineImage.WINDOWS_SERVER_2012_R2_DATACENTER)
                        .withAdminUserName(userName)
                        .withPassword(password)
                        .withSize(VirtualMachineSizeTypes.STANDARD_D3_V2)
                        .create();

                Date t2 = new Date();
                System.out.println("Created VM: (took "
                        + ((t2.getTime() - t1.getTime()) / 1000) + " seconds) " + vm.id());
                // Print virtual machine details
                Utils.print(vm);

                //============================================================
                // Gets the public Ip address associated with the VM's primary NIC

                System.out.println("Reading public Ip address associated with the VM's primary NIC [After create]");
                // Print the public Ip address details
                Utils.print(vm.primaryPublicIpAddress());

                //============================================================
                // Assign a new public IP address for the VM

                // Define a new public Ip address

                PublicIpAddress.DefinitionCreatable publicIpAddress2Creatable = azure.publicIpAddresses()
                        .define(publicIpAddressName2)
                        .withRegion(Region.US_EAST)
                        .withNewGroup(rgName)
                        .withLeafDomainLabel(publicIpAddressLeafDNS2);

                // Update VM's primary NIC to use the new public Ip address

                System.out.println("Updating the VM's primary NIC with new public Ip address");

                NetworkInterface primaryNetworkInterface = vm.primaryNetworkInterface();
                primaryNetworkInterface
                        .update()
                        .withNewPrimaryPublicIpAddress(publicIpAddress2Creatable)
                        .apply();

                //============================================================
                // Gets the updated public Ip address associated with the VM

                // Get the associated public IP address for a virtual machine
                System.out.println("Reading public Ip address associated with the VM's primary NIC [After Update]");
                vm.refresh();
                Utils.print(vm.primaryPublicIpAddress());

                //============================================================
                // Remove public Ip associated with the VM

                vm.refresh();
                primaryNetworkInterface = vm.primaryNetworkInterface();
                publicIpAddress = primaryNetworkInterface.primaryPublicIpAddress();
                primaryNetworkInterface.update()
                        .withoutPrimaryPublicIpAddress()
                        .apply();

                //============================================================
                // Delete the public ip
                System.out.println("Deleting the public Ip address");
                azure.publicIpAddresses().delete(publicIpAddress.id());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
                try {
                    System.out.println("Deleting Resource Group: " + rgName);
                    azure.resourceGroups().delete(rgName);
                    System.out.println("Deleted Resource Group: " + rgName);
                } catch (NullPointerException npe) {
                    System.out.println("Did not create any resources in Azure. No clean up is necessary");
                } catch (Exception g) {
                    g.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private ManageIPAddress() {
    }
}
