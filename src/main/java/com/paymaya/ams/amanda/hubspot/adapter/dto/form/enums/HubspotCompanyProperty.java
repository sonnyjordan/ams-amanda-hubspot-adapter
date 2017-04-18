package com.paymaya.ams.amanda.hubspot.adapter.dto.form.enums;

public enum HubspotCompanyProperty {
	
	SCHEDULE_FOR_PRE_SCREENING ("schedule_for_pre_screening"),
	SCHEDULE_FOR_ONBOARDING("schedule_for_onboarding"),
	SCHEDULE_FOR_PROVISIONING("schedule_for_provisioning"),
	DOCUMENTS_COMPLETE("schedule_for_documents_checking");
	
	String propertyName;
	
	HubspotCompanyProperty(String propertyName){
		this.propertyName = propertyName;
	}
	
	public String getPropertyName(){
		return propertyName;
	}
	

}
