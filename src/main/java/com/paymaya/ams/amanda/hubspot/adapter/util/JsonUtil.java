package com.paymaya.ams.amanda.hubspot.adapter.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Util to convert JSON String to Object, Object to JSON String
 *
 * @author Tristan Diaz
 */
public final class JsonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {

    }

    public static <T> T toObject(Class<T> clazz, String jsonString) throws Exception {

        try {
            return mapper.readValue(jsonString, clazz);
        } catch (IOException e) {

            LOGGER.error("Error Deserializing JSON String: {}", jsonString);

            throw new Exception(e);
        }
    }

    public static <T> String toJsonString(T object) throws Exception {

        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {

            LOGGER.error("Error Serializing object to json", e);

            throw new Exception(e);
        }
    }

    public static <T> T toObject(Class<T> clazz, File file) throws Exception {
        try {
            return mapper.readValue(file, clazz);
        } catch (IOException e) {

            LOGGER.error("Error Deserializing JSON File", e);

            throw new Exception(e);
        }
    }
}