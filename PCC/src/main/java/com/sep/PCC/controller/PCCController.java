package com.sep.PCC.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sep.PCC.model.Banka;
import com.sep.PCC.model.PCCRequest;
import com.sep.PCC.service.PCCService;

@RequestMapping("/api")
@RestController
public class PCCController {

    @Value("${issuer.url}")
    private String issuerUrl;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PCCService pccService;

    @RequestMapping(value = "/pass-payment", method = RequestMethod.POST)
    public ResponseEntity<String> checkAndPassPayment(@RequestBody PCCRequest pccRequest) {
        logger.info("checkAndPassPayment pcc, pan: {}", pccRequest.getBuyersPan());

        ResponseEntity<String> response = new RestTemplate().postForEntity(issuerUrl + "/api/make-payment", pccRequest,
                String.class);

        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());

    }
}
