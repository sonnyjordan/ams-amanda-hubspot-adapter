package com.paymaya.ams.amanda.hubspot.adapter.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.xml.bind.DatatypeConverter;

@RestController
@RequestMapping(value = "/hubspot")
public class SubscriptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionController.class);

    @RequestMapping(value = "/webhook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void submitForm(@RequestBody String body, @RequestHeader(name = "X-HubSpot-Signature") String signature) throws NoSuchAlgorithmException {
    	
    	LOGGER.info("body: {}", body);
    	 
        LOGGER.info("signature: {}", signature);
        
        String keyPlusBody = "2edebaad-831e-40ea-9a20-e9c6a48ce18b" + body;
        
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        
        byte[] hash = digest.digest(keyPlusBody.getBytes(StandardCharsets.UTF_8));
        
        String hello = DatatypeConverter.printHexBinary(hash);
        
        LOGGER.info("hashed app secret and body: {}", hello);

    }
}

