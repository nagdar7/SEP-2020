package com.sep.BitCoin.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.sep.BitCoin.model.BitCoin;
import com.sep.BitCoin.service.BitCoinService;

@RequestMapping("/api")
@RestController
public class BitCoinController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitCoinService bitCoinService;

    @RequestMapping(value = "/bit-coin", method = RequestMethod.POST)
    public ResponseEntity Check(@RequestBody BitCoin user) {
        logger.debug("checkout payment passed by bank, id: {}, price: {}", user.getId(), user.getIznos());
        List<BitCoin> accounts = new ArrayList<>();
        accounts = bitCoinService.returnAllAccounts();
        // accounts = new ArrayList<>();

        if (accounts.size() > 0) {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getBrojKartice() == user.getBrojKartice()
                        && accounts.get(i).getPin() == user.getPin()) {
                    if (accounts.get(i).getIznos() >= user.getIznos()) {
                        RestTemplate restTemplate = new RestTemplate();
                        return ResponseEntity.status(HttpStatus.OK).body("Uspesna transakcija");
                    } else {
                        return ResponseEntity.status(HttpStatus.OK).body("Korisnik nema dovoljno novca na racunu!");
                    }
                } else {
                    return ResponseEntity.status(HttpStatus.OK).body("Trazeni racun ne postoji!");
                }
            }
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Trazeni racun ne postojit!");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Nema racuna");
    }
}