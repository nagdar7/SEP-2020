package com.sep.PCC.controller;

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

import com.sep.PCC.model.Banka;
import com.sep.PCC.service.PCCService;

@RequestMapping("/api")
@RestController
public class PCCController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PCCService pccService;

    @RequestMapping(value = "/aq", method = RequestMethod.POST)
    public ResponseEntity Check(@RequestBody Banka user) {
        logger.info("checkout payment passed by bank, id: {}, price: {}", user.getId(), user.getIznos());

        return ResponseEntity.status(HttpStatus.OK).body("Nema racuna");

    }
}
