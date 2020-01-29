package com.sep.NC.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin
public class MagazineController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


	@RequestMapping(value = "api/getMagazines", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllMagazines() {
        try {
            List<String> magazines = new ArrayList<String>();
            magazines.add("Casopis 1");
            magazines.add("Casopis 2");
            magazines.add("Casopis 3");

            return new ResponseEntity<>(magazines, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }


	@RequestMapping(value = "/api/getPaymentMethods/{applicationName}", method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPaymentMethods(@PathVariable String applicationName) {
		logger.debug("Get all payment methods");
        System.out.println("Dosao sam do slanjaaaaaaa!");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8765/api/getServices/"+applicationName, String.class);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}
