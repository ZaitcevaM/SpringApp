package com.example;

import com.example.model.ApiRequest;
import com.example.service.ApiRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@RestController
@EnableAutoConfiguration
public class ApiRequestController {

    @Autowired
    private ApiRequestService apiRequestService;

    private static final Logger logger = LoggerFactory.getLogger(ApiRequestController.class);

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String createObject() {
        logger.info("Api request received");

        String response;
        try {
            ApiRequest apiRequest = new ApiRequest(new Date());
            apiRequestService.create(apiRequest);
            response = "Object with id 1 was created successfully";
        } catch (Exception e) {
            logger.error("Error occurred while trying to process api request", e);
            response = "Error";
        }

        return response;
    }

    @RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getObject() {
        logger.info("Api request received");

        String response;
        try {
            final Date requestTime = apiRequestService.getRequestTime(1L);
            response = requestTime.toString();
        } catch (Exception e) {
            logger.error("Error occurred while trying to process api request", e);
            response = "Error";
        }
        return response;
    }
}
