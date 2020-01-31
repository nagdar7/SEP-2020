package com.sep.NC.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sep.NC.dto.FormField;
import com.sep.NC.dto.FormFieldsDTO;

@RestController
@CrossOrigin
public class RoutingController {
	
	@RequestMapping(value = "api/payment-subscriptions/{subscription}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> GetSubscription(@PathVariable String subscription) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<FormField>> response = restTemplate.exchange("http://localhost:8765/" + subscription + "/api/form-fields-for-payment-type",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<FormField>>() {
            });
    		return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
            
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }
}
