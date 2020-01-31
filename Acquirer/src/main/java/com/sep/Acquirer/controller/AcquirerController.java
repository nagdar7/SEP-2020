package com.sep.Acquirer.controller;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sep.Acquirer.model.BankAccount;
import com.sep.Acquirer.model.FormField;
import com.sep.Acquirer.model.PaymentModel;
import com.sep.Acquirer.model.PaymentRequest;
import com.sep.Acquirer.service.AcquirerService;

@RequestMapping("/api")
@RestController
public class AcquirerController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AcquirerService acquirerService;

    @Autowired
    Environment environment;

    @RequestMapping(value = "/create-payment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PaymentModel createPayment(HttpServletRequest request, @RequestBody PaymentRequest paymentRequest)
            throws MalformedURLException {
        logger.info("createPayment");
        Date date = new Date();
        paymentRequest.setMerchantTimestamp(date);
        PaymentModel p = new PaymentModel();
        p.setPaymentRequest(paymentRequest);
        // MerchantAccount merchant =
        // merchantAccountRep.findBymerchantId(paymentRequest.getMerchantId());

        URL requestURL = new URL(request.getRequestURL().toString());
        String port = requestURL.getPort() == -1 ? "" : ":" + requestURL.getPort();
        String address = requestURL.getProtocol() + "://" + requestURL.getHost() + port;
        // request.getRequestURL().toString();
        // //
        // InetAddress.getLoopbackAddress().getHostName();
        // String port = environment.getProperty("server.port");

        logger.info("createPayment, address: {}", address);

        // if (!port.equals("")) {
        // address = address + ":" + port;
        // }
        // logger.info("createPayment, address: {}", address);
        p.setPaymentUrl(address + "/api/form-fields");
        // TODO: POSNIMATI OVO U BAZI

        // merchant.getClientAccount().getPortNumber() + "/#/paymentInput");
        // paymentRequestRep.save(paymentRequest);
        // paymentRep.save(p);
        return p;
    }

    @RequestMapping(path = "/form-fields", method = RequestMethod.GET)
    public ResponseEntity<List<FormField>> getUIForForBuyer() throws IOException {
        logger.info("serve return form fields for ui");
        List<FormField> formFields = new ArrayList<>();
        formFields.add(new FormField("pan", "Credit card number", "text", false));
        formFields.add(new FormField("securityCode", "ccv2", "text", false));
        formFields.add(new FormField("cardHolderName", "Cardholder Name", "text", false));
        formFields.add(new FormField("expiryYear", "Year of expiry", "text", false));
        formFields.add(new FormField("expiryMonth", "Month of expiry", "text", false));
        return new ResponseEntity<List<FormField>>(formFields, HttpStatus.OK);
    }

    @RequestMapping(value = "/make-payment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PaymentModel makePayment(@RequestBody BankAccount bankAccount) {
        logger.info("makePayment");
        // Date date = new Date();
        // paymentRequest.setMerchantTimestamp(date);
        PaymentModel p = new PaymentModel();
        // p.setPaymentRequest(paymentRequest);
        // MerchantAccount merchant =
        // merchantAccountRep.findBymerchantId(paymentRequest.getMerchantId());

        // p.setPaymentUrl("http://localhost:" +
        // merchant.getClientAccount().getPortNumber() + "/#/paymentInput");
        // paymentRequestRep.save(paymentRequest);
        // paymentRep.save(p);
        return p;
    }

}
