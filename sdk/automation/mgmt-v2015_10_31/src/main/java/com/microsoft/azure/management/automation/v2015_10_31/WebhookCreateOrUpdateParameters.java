/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.automation.v2015_10_31;

import org.joda.time.DateTime;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * The parameters supplied to the create or update webhook operation.
 */
@JsonFlatten
public class WebhookCreateOrUpdateParameters {
    /**
     * Gets or sets the name of the webhook.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * Gets or sets the value of the enabled flag of webhook.
     */
    @JsonProperty(value = "properties.isEnabled")
    private Boolean isEnabled;

    /**
     * Gets or sets the uri.
     */
    @JsonProperty(value = "properties.uri")
    private String uri;

    /**
     * Gets or sets the expiry time.
     */
    @JsonProperty(value = "properties.expiryTime")
    private DateTime expiryTime;

    /**
     * Gets or sets the parameters of the job.
     */
    @JsonProperty(value = "properties.parameters")
    private Map<String, String> parameters;

    /**
     * Gets or sets the runbook.
     */
    @JsonProperty(value = "properties.runbook")
    private RunbookAssociationProperty runbook;

    /**
     * Gets or sets the name of the hybrid worker group the webhook job will
     * run on.
     */
    @JsonProperty(value = "properties.runOn")
    private String runOn;

    /**
     * Get gets or sets the name of the webhook.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set gets or sets the name of the webhook.
     *
     * @param name the name value to set
     * @return the WebhookCreateOrUpdateParameters object itself.
     */
    public WebhookCreateOrUpdateParameters withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get gets or sets the value of the enabled flag of webhook.
     *
     * @return the isEnabled value
     */
    public Boolean isEnabled() {
        return this.isEnabled;
    }

    /**
     * Set gets or sets the value of the enabled flag of webhook.
     *
     * @param isEnabled the isEnabled value to set
     * @return the WebhookCreateOrUpdateParameters object itself.
     */
    public WebhookCreateOrUpdateParameters withIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
        return this;
    }

    /**
     * Get gets or sets the uri.
     *
     * @return the uri value
     */
    public String uri() {
        return this.uri;
    }

    /**
     * Set gets or sets the uri.
     *
     * @param uri the uri value to set
     * @return the WebhookCreateOrUpdateParameters object itself.
     */
    public WebhookCreateOrUpdateParameters withUri(String uri) {
        this.uri = uri;
        return this;
    }

    /**
     * Get gets or sets the expiry time.
     *
     * @return the expiryTime value
     */
    public DateTime expiryTime() {
        return this.expiryTime;
    }

    /**
     * Set gets or sets the expiry time.
     *
     * @param expiryTime the expiryTime value to set
     * @return the WebhookCreateOrUpdateParameters object itself.
     */
    public WebhookCreateOrUpdateParameters withExpiryTime(DateTime expiryTime) {
        this.expiryTime = expiryTime;
        return this;
    }

    /**
     * Get gets or sets the parameters of the job.
     *
     * @return the parameters value
     */
    public Map<String, String> parameters() {
        return this.parameters;
    }

    /**
     * Set gets or sets the parameters of the job.
     *
     * @param parameters the parameters value to set
     * @return the WebhookCreateOrUpdateParameters object itself.
     */
    public WebhookCreateOrUpdateParameters withParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Get gets or sets the runbook.
     *
     * @return the runbook value
     */
    public RunbookAssociationProperty runbook() {
        return this.runbook;
    }

    /**
     * Set gets or sets the runbook.
     *
     * @param runbook the runbook value to set
     * @return the WebhookCreateOrUpdateParameters object itself.
     */
    public WebhookCreateOrUpdateParameters withRunbook(RunbookAssociationProperty runbook) {
        this.runbook = runbook;
        return this;
    }

    /**
     * Get gets or sets the name of the hybrid worker group the webhook job will run on.
     *
     * @return the runOn value
     */
    public String runOn() {
        return this.runOn;
    }

    /**
     * Set gets or sets the name of the hybrid worker group the webhook job will run on.
     *
     * @param runOn the runOn value to set
     * @return the WebhookCreateOrUpdateParameters object itself.
     */
    public WebhookCreateOrUpdateParameters withRunOn(String runOn) {
        this.runOn = runOn;
        return this;
    }

}