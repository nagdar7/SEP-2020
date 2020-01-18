package com.sep.controller;

import java.util.ArrayList;
import java.util.List;

import com.sep.model.Seller;
import com.sep.services.SellersService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class SellersController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SellersService sellersService;

    @RequestMapping(value = "/sellers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Seller>> getAllSellers() {
        logger.debug("getting all sellers");
        return new ResponseEntity<List<Seller>>(sellersService.returnAllSellers(), HttpStatus.OK);
    }

}