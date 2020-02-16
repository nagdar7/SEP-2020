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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import com.sep.NC.model.Magazine;
import com.sep.NC.model.Seller;
import com.sep.NC.repository.MagazineRepository;
import com.sep.NC.service.MagazineService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
public class MagazineController {

    @Autowired
    MagazineService magazineService;

    @Value("${kp.url}")
    String kpUrl;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "api/getMagazines", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllMagazines() {
        try {
            List<Magazine> allMagazines = magazineService.findAll();

            return new ResponseEntity<>(allMagazines, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/api/getPaymentMethods/{applicationName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPaymentMethods(@PathVariable String applicationName) {
        logger.debug("Get all payment methods");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<String>> response = restTemplate.exchange(
                kpUrl + "eureka/api/service-instances/" + applicationName, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<String>>() {
                });
        return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
    }

    @RequestMapping(value = "/api/insertMagazine", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Magazine> insertMagazine(@RequestBody Magazine magazine) {
        logger.info("insert new magazine");
        magazineService.save(magazine);
        return new ResponseEntity<Magazine>(magazine, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/addSeller", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Seller> insertMagazine(@RequestBody Seller seller) {
        logger.info("add new seller");
        System.out.println(seller.getPaymentTypes().size());
        System.out.println(seller.getPaymentTypes().get(0));
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Seller> response = restTemplate.postForEntity(kpUrl + "sellers/api/insertSeller", seller,
                Seller.class);
        return new ResponseEntity<Seller>(response.getBody(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/getPaymentTypesForMagazine/{pib}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPaymentTypesForMagazine(@PathVariable String pib) {
        logger.info("Get all payment methods");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<String>> response = restTemplate.exchange(kpUrl + "sellers/api/getPaymentTypes/" + pib,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
                });
        return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
    }

}
