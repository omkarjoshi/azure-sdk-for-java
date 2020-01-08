/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservices.siterecovery.v2018_01_10;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Recovery plan A2A failover input.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "instanceType")
@JsonTypeName("A2A")
public class RecoveryPlanA2AFailoverInput extends RecoveryPlanProviderSpecificFailoverInput {
    /**
     * The recovery point type. Possible values include: 'Latest',
     * 'LatestApplicationConsistent', 'LatestCrashConsistent',
     * 'LatestProcessed'.
     */
    @JsonProperty(value = "recoveryPointType", required = true)
    private A2ARpRecoveryPointType recoveryPointType;

    /**
     * A value indicating whether to use recovery cloud service for TFO or not.
     */
    @JsonProperty(value = "cloudServiceCreationOption")
    private String cloudServiceCreationOption;

    /**
     * A value indicating whether multi VM sync enabled VMs should use multi VM
     * sync points for failover. Possible values include:
     * 'UseMultiVmSyncRecoveryPoint', 'UsePerVmRecoveryPoint'.
     */
    @JsonProperty(value = "multiVmSyncPointOption")
    private MultiVmSyncPointOption multiVmSyncPointOption;

    /**
     * Get the recovery point type. Possible values include: 'Latest', 'LatestApplicationConsistent', 'LatestCrashConsistent', 'LatestProcessed'.
     *
     * @return the recoveryPointType value
     */
    public A2ARpRecoveryPointType recoveryPointType() {
        return this.recoveryPointType;
    }

    /**
     * Set the recovery point type. Possible values include: 'Latest', 'LatestApplicationConsistent', 'LatestCrashConsistent', 'LatestProcessed'.
     *
     * @param recoveryPointType the recoveryPointType value to set
     * @return the RecoveryPlanA2AFailoverInput object itself.
     */
    public RecoveryPlanA2AFailoverInput withRecoveryPointType(A2ARpRecoveryPointType recoveryPointType) {
        this.recoveryPointType = recoveryPointType;
        return this;
    }

    /**
     * Get a value indicating whether to use recovery cloud service for TFO or not.
     *
     * @return the cloudServiceCreationOption value
     */
    public String cloudServiceCreationOption() {
        return this.cloudServiceCreationOption;
    }

    /**
     * Set a value indicating whether to use recovery cloud service for TFO or not.
     *
     * @param cloudServiceCreationOption the cloudServiceCreationOption value to set
     * @return the RecoveryPlanA2AFailoverInput object itself.
     */
    public RecoveryPlanA2AFailoverInput withCloudServiceCreationOption(String cloudServiceCreationOption) {
        this.cloudServiceCreationOption = cloudServiceCreationOption;
        return this;
    }

    /**
     * Get a value indicating whether multi VM sync enabled VMs should use multi VM sync points for failover. Possible values include: 'UseMultiVmSyncRecoveryPoint', 'UsePerVmRecoveryPoint'.
     *
     * @return the multiVmSyncPointOption value
     */
    public MultiVmSyncPointOption multiVmSyncPointOption() {
        return this.multiVmSyncPointOption;
    }

    /**
     * Set a value indicating whether multi VM sync enabled VMs should use multi VM sync points for failover. Possible values include: 'UseMultiVmSyncRecoveryPoint', 'UsePerVmRecoveryPoint'.
     *
     * @param multiVmSyncPointOption the multiVmSyncPointOption value to set
     * @return the RecoveryPlanA2AFailoverInput object itself.
     */
    public RecoveryPlanA2AFailoverInput withMultiVmSyncPointOption(MultiVmSyncPointOption multiVmSyncPointOption) {
        this.multiVmSyncPointOption = multiVmSyncPointOption;
        return this;
    }

}