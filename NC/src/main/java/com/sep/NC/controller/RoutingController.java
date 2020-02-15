package com.sep.NC.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import com.sep.NC.dto.FormField;
import com.sep.NC.dto.FormFieldsDTO;
import com.sep.NC.dto.PayItemsDTO;
import com.sep.NC.dto.RedirectDTO;
import com.sep.NC.model.Seller;

@RestController
@CrossOrigin
public class RoutingController {

    @RequestMapping(value = "api/payment-subscriptions/{subscription}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> GetSubscription(@PathVariable String subscription) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List<FormField>> response = restTemplate.exchange(
                    "http://localhost:8765/" + subscription + "/api/form-fields-for-payment-type", HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<FormField>>() {
                    });
            return ResponseEntity.status(HttpStatus.OK).body(response.getBody());

        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "api/payment-subscriptions/{subscription}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> Pay(@PathVariable String subscription, @RequestBody List<PayItemsDTO> items) {
        try {
            System.out.println(subscription);
            // System.out.print(items.toString());
            Map<String, String> mapItems = items.stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getValue()));
            System.out.println(mapItems.toString());
            ResponseEntity<String> response = new RestTemplate()
                    .postForEntity("http://localhost:8765/" + subscription + "/api/pay", mapItems, String.class);
            System.out.println(response);
            return ResponseEntity.status(HttpStatus.OK).body(response.getBody());

        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body("http://localhost:4200/");
        }
    }
}
