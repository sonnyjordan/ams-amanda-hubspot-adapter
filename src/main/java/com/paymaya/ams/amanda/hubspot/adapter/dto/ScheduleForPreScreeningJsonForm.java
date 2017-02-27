package com.paymaya.ams.amanda.hubspot.adapter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleForPreScreeningJsonForm {
	
	private int eventId;
	private int subscriptionId;
	private int portalId;
	private int appId;
	private int occurredAt;
	private String subscriptionType;
	private int objectId;
	private String propertyName;
	private String propertyValue;
	private String changeSource;
	private int attemptNumber;

}
