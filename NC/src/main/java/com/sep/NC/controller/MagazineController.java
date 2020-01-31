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

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import com.sep.NC.model.Magazine;
import com.sep.NC.model.Seller;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
public class MagazineController {

    private List<Magazine> allMagazines = new ArrayList<Magazine>();

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public MagazineController() {
        allMagazines.add(new Magazine("Magazin 1", "256487"));
        allMagazines.add(new Magazine("Magazin 2", "214365"));
    }

	@RequestMapping(value = "api/getMagazines", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllMagazines() {
        try {
            //allMagazines.add(new Magazine("Magazin 1", "256487"));
            //allMagazines.add(new Magazine("Magazin 2", "214365"));

            return new ResponseEntity<>(allMagazines, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }


	@RequestMapping(value = "/api/getPaymentMethods/{applicationName}", method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPaymentMethods(@PathVariable String applicationName) {
		logger.debug("Get all payment methods");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<String>> response = restTemplate.exchange("http://localhost:8765/eureka/api/service-instances/"+applicationName,
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
            });
		return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
	}


    @RequestMapping(value = "/api/insertMagazine", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Magazine> insertMagazine(@RequestBody Magazine magazine) {
        logger.debug("insert new magazine");
        allMagazines.add(magazine);
        return new ResponseEntity<Magazine>(magazine, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/addSeller", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertMagazine(@RequestBody Seller seller) {
        logger.debug("add new seller");
        RestTemplate restTemplate = new RestTemplate();
        Seller response = restTemplate.postForObject("http://localhost:8765/sellers/api/insertSeller",
                    seller, Seller.class);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
	
}
