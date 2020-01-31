package com.sep.Sellers.controller;

import java.util.ArrayList;
import java.util.List;

import com.sep.Sellers.model.Seller;
import com.sep.Sellers.services.SellersService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/api")
public class SellersController {

    private List<Seller> allSellers = new ArrayList<Seller>();

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SellersService sellersService;

    @RequestMapping(value = "/sellers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Seller>> getAllSellers() {
        logger.debug("getting all sellers");
        List<Seller> temp = sellersService.returnAllSellers();
        for(Seller s: temp){
            allSellers.add(s);
        }
        return new ResponseEntity<List<Seller>>(sellersService.returnAllSellers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/insertSeller", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertSeller(@RequestBody Seller seller) {
        logger.debug("insert new seller");
        allSellers.add(seller);
        for(Seller s : allSellers){
            System.out.println(s.toString());
        }
        return new ResponseEntity<Seller>(seller, HttpStatus.OK);
    }

}