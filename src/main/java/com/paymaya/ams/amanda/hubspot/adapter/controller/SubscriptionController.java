package com.paymaya.ams.amanda.hubspot.adapter.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paymaya.ams.amanda.hubspot.adapter.dto.form.HubspotWebhookJsonForm;
import com.paymaya.ams.amanda.hubspot.adapter.dto.form.enums.HubspotCompanyProperty;

@RestController
@RequestMapping(value = "/hubspot")
public class SubscriptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionController.class);

    @RequestMapping(value = "/webhook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object submitForm(@RequestBody HubspotWebhookJsonForm [] form) {
    	
    	LOGGER.info("Process Webhook Subscription for Hub Spot Company with ID: {}", form[0].getObjectId());
    	

        //LOGGER.info("signature: {}", signature);

    	
    	String propertyName = form[0].getPropertyName();
    	
    	if(propertyName.equals(HubspotCompanyProperty.SCHEDULE_FOR_PRE_SCREENING.getPropertyName())){
    		
    	}

        return "hello";
    }
}

