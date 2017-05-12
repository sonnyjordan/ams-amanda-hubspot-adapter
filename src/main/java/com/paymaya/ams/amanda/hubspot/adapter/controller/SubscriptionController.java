package com.paymaya.ams.amanda.hubspot.adapter.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymaya.ams.amanda.hubspot.adapter.dto.form.HubspotWebhookJsonForm;
import com.paymaya.ams.amanda.hubspot.adapter.util.JsonUtil;

import javax.xml.bind.DatatypeConverter;

@RestController
@RequestMapping(value = "/hubspot")
public class SubscriptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionController.class);

    String appSecret = "2edebaad-831e-40ea-9a20-e9c6a48ce18b";
    
    @RequestMapping(value = "/webhook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void submitForm(@RequestBody String body, @RequestHeader(name = "X-HubSpot-Signature") String signature) throws Exception{
    	    	    	
    	//verifySignature(body, signature);
    	
    	LOGGER.info("body: {}", body );
      	 
        LOGGER.info("signature: {}", signature);
    	
    	LOGGER.info("Converting to HubspotWebhookJsonForm");
    	
    	HubspotWebhookJsonForm [] hubspotWebhookJsonForm = JsonUtil.toObject(HubspotWebhookJsonForm[].class, body);
    	
    	LOGGER.info("" + hubspotWebhookJsonForm[0].getAppId());

    }
    
    private void verifySignature(String body, String signature) throws Exception{
    	
    	LOGGER.info("body: {}", body );
   	 
        LOGGER.info("signature: {}", signature);
        
        String appSecretAndRequestBody =  appSecret + body;
        
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        
        byte[] hashedValue = digest.digest(appSecretAndRequestBody.getBytes(StandardCharsets.UTF_8));
        
        String digestValue = DatatypeConverter.printHexBinary(hashedValue);
        
    	LOGGER.info("digestValue {} :", digestValue);

        
        if(!digestValue.equalsIgnoreCase(signature)){
        	
        	LOGGER.info("Invalid Request Signature");
        	
        	throw new Exception("Invalid Request Signature");
        }
        
        LOGGER.info("Valid Request Signature");
    }
}

