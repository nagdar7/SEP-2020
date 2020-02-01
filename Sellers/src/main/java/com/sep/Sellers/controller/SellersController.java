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
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/api")
public class SellersController {

    private List<Seller> allSellers = new ArrayList<Seller>();

    public SellersController() {
        //allMagazines.add(new Magazine("Magazin 1", "256487"));
        List<String> pt1 = new ArrayList<String>();
		Seller s1 = new Seller("Magazin 1", "256487");
		pt1.add("CREDITCARD");
		pt1.add("PAYPAL");
        s1.setPaymentTypes(pt1);
        List<String> pt2 = new ArrayList<String>();
		Seller s2 = new Seller("Magazin 2", "214365");
		pt2.add("PAYPAL");
		pt2.add("BITCOIN");
        s2.setPaymentTypes(pt2);
		allSellers.add(s1);
		allSellers.add(s2);
    }

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SellersService sellersService;

    @RequestMapping(value = "/sellers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Seller>> getAllSellers() {
        logger.info("getting all sellers");
        // List<Seller> temp = sellersService.returnAllSellers();
        // for(Seller s: temp){
        //     allSellers.add(s);
        // }
        return new ResponseEntity<List<Seller>>(allSellers, HttpStatus.OK);
    }

    @RequestMapping(value = "/insertSeller", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertSeller(@RequestBody Seller seller) {
        logger.info("insert new seller");
        System.out.println(seller.getPaymentTypes().size());
        System.out.println(seller.getPaymentTypes().get(0));
        allSellers.add(seller);
        // for(Seller s : allSellers){
        //     System.out.println(s.toString());
        // }
        return new ResponseEntity<Seller>(seller, HttpStatus.OK);
    }

    @RequestMapping(value = "/getPaymentTypes/{pib}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getPaymentTypes(@PathVariable String pib) {
        logger.info("getting all payment types for magazine");
        // List<Seller> temp = sellersService.returnAllSellers();

        System.out.println(allSellers.size());
        List<String> paymentTypes = new ArrayList<String>();
        for(Seller s: allSellers){
            System.out.println(s.getPib());
            if(s.getPib().equals(pib)){
                for(String t : s.getPaymentTypes()){
                    paymentTypes.add(t);
                }
            }
        }
        return new ResponseEntity<List<String>>(paymentTypes, HttpStatus.OK);
    }

}