/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.mediaservices.v2019_05_01_preview.implementation;

import java.util.List;
import com.microsoft.azure.management.mediaservices.v2019_05_01_preview.AssetStreamingLocator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Streaming Locators associated with this Asset.
 */
public class ListStreamingLocatorsResponseInner {
    /**
     * The list of Streaming Locators.
     */
    @JsonProperty(value = "streamingLocators", access = JsonProperty.Access.WRITE_ONLY)
    private List<AssetStreamingLocator> streamingLocators;

    /**
     * Get the list of Streaming Locators.
     *
     * @return the streamingLocators value
     */
    public List<AssetStreamingLocator> streamingLocators() {
        return this.streamingLocators;
    }

}