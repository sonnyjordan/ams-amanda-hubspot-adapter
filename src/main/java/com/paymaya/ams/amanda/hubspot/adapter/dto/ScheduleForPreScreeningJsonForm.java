package com.paymaya.ams.amanda.hubspot.adapter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleForPreScreeningJsonForm {
	
	private long eventId;
	private long subscriptionId;
	private long portalId;
	private long appId;
	private long occurredAt;
	private String subscriptionType;
	private long objectId;
	private String propertyName;
	private String propertyValue;
	private String changeSource;
	private long attemptNumber;

}
