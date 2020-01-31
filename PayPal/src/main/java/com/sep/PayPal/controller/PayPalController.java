package com.sep.PayPal.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sep.PayPal.dto.FormFieldsDTO;
import com.sep.PayPal.dto.UrlDTO;
import com.sep.PayPal.model.FormField;
import com.sep.PayPal.model.PayPal;
import com.sep.PayPal.service.PayPalService;

@RequestMapping("/api")
@RestController
public class PayPalController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PayPalService payPalService;

    @RequestMapping(value = "/pay-pal", method = RequestMethod.POST)
    public ResponseEntity Check(@RequestBody PayPal user) {
        logger.debug("checkout payment passed by bank, id: {}, price: {}", user.getId(), user.getIznos());
        List<PayPal> accounts = new ArrayList<>();
        accounts = payPalService.returnAllAccounts();

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
    
	@RequestMapping(value = "/frontend-url", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UrlDTO> getFrontendUrl()
    {
		return new ResponseEntity<UrlDTO>(new UrlDTO(payPalService.getPayPalUrl()), HttpStatus.OK);
    }
	
	 @RequestMapping(value = "/form-fields-for-payment-type", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<List<FormField>> getFormFieldsForPaymentTypes() {
		    List<FormField> formFieldsForPaymentTypeDTO = payPalService.getFormFieldsForPaypal();
	        System.out.println("aaaaa");
		    return new ResponseEntity<List<FormField>>(formFieldsForPaymentTypeDTO, HttpStatus.OK);
	    }
	
}
