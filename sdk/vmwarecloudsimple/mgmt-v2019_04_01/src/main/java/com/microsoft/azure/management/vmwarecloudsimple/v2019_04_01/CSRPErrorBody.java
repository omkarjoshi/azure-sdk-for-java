/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.vmwarecloudsimple.v2019_04_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Error properties.
 */
public class CSRPErrorBody {
    /**
     * Error's code.
     */
    @JsonProperty(value = "code", access = JsonProperty.Access.WRITE_ONLY)
    private String code;

    /**
     * Error's details.
     */
    @JsonProperty(value = "details", access = JsonProperty.Access.WRITE_ONLY)
    private List<CSRPErrorBody> details;

    /**
     * Error's message.
     */
    @JsonProperty(value = "message", access = JsonProperty.Access.WRITE_ONLY)
    private String message;

    /**
     * Error's target.
     */
    @JsonProperty(value = "target")
    private String target;

    /**
     * Get error's code.
     *
     * @return the code value
     */
    public String code() {
        return this.code;
    }

    /**
     * Get error's details.
     *
     * @return the details value
     */
    public List<CSRPErrorBody> details() {
        return this.details;
    }

    /**
     * Get error's message.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

    /**
     * Get error's target.
     *
     * @return the target value
     */
    public String target() {
        return this.target;
    }

    /**
     * Set error's target.
     *
     * @param target the target value to set
     * @return the CSRPErrorBody object itself.
     */
    public CSRPErrorBody withTarget(String target) {
        this.target = target;
        return this;
    }

}