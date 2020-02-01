package com.sep.Issuer.controller;

import java.util.ArrayList;
import java.util.List;

import com.sep.Issuer.model.Banka;
import com.sep.Issuer.model.PCCRequest;
import com.sep.Issuer.service.IssuerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api")
@RestController
public class IssuerController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IssuerService issuerService;

    @RequestMapping(value = "/make-payment", method = RequestMethod.POST)
    public ResponseEntity makePayment(@RequestBody PCCRequest pccRequest) {
        logger.info("make payment for issuer, buyer pan: {}", pccRequest.getBuyersPan());
        List<Banka> accounts = new ArrayList<>();
        accounts = issuerService.returnAllAccounts();

        if (accounts.size() > 0) {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getBrojKartice().equals(pccRequest.getBuyersPan())
                        && accounts.get(i).getPin().equals(pccRequest.getBankAccount().getSecurityCode())) {
                    if (accounts.get(i).getIznos() >= pccRequest.getBankAccount().getReservedFunds()) {
                        RestTemplate restTemplate = new RestTemplate();
                        return ResponseEntity.status(HttpStatus.OK).body("SUCCESS");
                    } else {
                        return ResponseEntity.status(HttpStatus.OK).body("FAIL"); // Korisnik nema dovoljno novca na
                                                                                  // racunu!");
                    }
                }
            }
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("FAIL"); // Trazeni racun ne postojit!");
        }
        return ResponseEntity.status(HttpStatus.OK).body("FAIL");// Nema racuna");

    }
}
