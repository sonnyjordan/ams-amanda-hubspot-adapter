package com.paymaya.ams.amanda.hubspot.adapter.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paymaya.ams.amanda.hubspot.adapter.dto.ScheduleForPreScreeningJsonForm;

@RestController
@RequestMapping(value = "/hubspot")
public class SubscriptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionController.class);

    @RequestMapping(value = "/prescreening", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Object submitForm(@RequestBody ScheduleForPreScreeningJsonForm form) {

        LOGGER.info("Process application form request for merchant:");


        Map<String, Object> result = new HashMap<>();
        result.put("companyId", form.getObjectId());

        return result;
    }
}

