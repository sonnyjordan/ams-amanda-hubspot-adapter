package com.paymaya.ams.amanda.hubspot.adapter.dto.form;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HubspotWebhookJsonForm {

	@JsonProperty("objectId")
	private Long objectId;

	@JsonProperty("propertyName")
	private String requestType;

	@JsonProperty("propertyValue")
	private String requestTypeValue;

	@JsonProperty("changedSource")
	private String changeSource;

	@JsonProperty("eventId")
	private Long eventId;

	@JsonProperty("subscriptionId")
	private Long subscriptionId;

	@JsonProperty("PortalId")
	private Long portalId;

	@JsonProperty("appId")
	private Long appId;

	@JsonProperty("occurredAt")
	private Long occurredAt;

	@JsonProperty("subscriptionType")
	private String subscriptionType;

	@JsonProperty("attemptNumber")
	private Long attemptNumber;

	@Override
	public String toString() {

		return "{\"eventId\":" + "\"" + eventId + "\"," +
				"\"subscriptionId\":" + "\"" + subscriptionId + "\"," +
				"\"portalId\":" + "\"" + portalId + "\"," +
				"\"appId\":" + "\"" + appId + "\"," +
				"\"occurredAt\":" + "\"" + occurredAt + "\"," +
				"\"subscriptionType\":" + "\"" + subscriptionType + "\"," +
				"\"objectId\":" + "\"" + objectId + "\"," +
				"\"propertyName\":" + "\"" + requestType + "\"," +
				"\"propertyValue\":" + "\"" + requestTypeValue + "\"," +
				"\"changeSource\":" + "\"" + changeSource + "\"," +
				"\"attemptNumber\":" + "\"" + attemptNumber + "\"}";
	}
}
