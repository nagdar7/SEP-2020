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

@RestController
@CrossOrigin
public class MagazineController {

	@RequestMapping(value = "api/getMagazines", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllDiseases() {
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
	
}
