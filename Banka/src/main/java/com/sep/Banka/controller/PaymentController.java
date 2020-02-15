package com.sep.Banka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sep.Banka.mapper.BankAccountMapper;
import com.sep.Banka.model.BankAccountDTO;
import com.sep.Banka.model.FormField;
import com.sep.Banka.model.PaymentModel;
import com.sep.Banka.model.PaymentRequest;

@RequestMapping("/api")
@RestController
public class PaymentController {

	@Value("${acquier.url}")
	private String acquierUrl;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(path = "/form-fields-for-payment-type", method = RequestMethod.GET)
	public ResponseEntity<List<FormField>> getUIForForBuyer() throws IOException {
		PaymentRequest paymentRequest = new PaymentRequest("", "", 0, new Date(), 0.0, "", "", "");
		logger.info("get ui for pay, id: {}", paymentRequest.getMerchantOrderId());
		// TODO: POKUPI STVARI STO TI TREBAJU
		// SNIMI U BAZU
		// POSALJI DALJE
		ResponseEntity<PaymentModel> modelResponse = new RestTemplate()
				.postForEntity(acquierUrl + "/api/create-payment", paymentRequest, PaymentModel.class);

		logger.info("returned from acquirer: {}", modelResponse);

		ResponseEntity<List<FormField>> response = new RestTemplate().exchange(modelResponse.getBody().getPaymentUrl(),
				HttpMethod.GET, null, new ParameterizedTypeReference<List<FormField>>() {
				});

		return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
	}

	@RequestMapping(path = "/pay", method = RequestMethod.POST)
	public ResponseEntity<String> makePayment(@RequestBody Map<String, String> items) {
		BankAccountDTO bankAccountDTO = new BankAccountDTO(items.get("pan"), items.get("securityCode"),
				items.get("cardHolderName"), items.get("expiryYear"), items.get("expiryMonth"), items.get("successUrl"),
				items.get("failedUrl"), items.get("errorUrl"));
		logger.info("makePayment, bankAccountDTO: {}", bankAccountDTO);
		ResponseEntity<String> response = new RestTemplate().postForEntity(acquierUrl + "/api/make-payment",
				BankAccountMapper.toBankAccount(bankAccountDTO), String.class);
		switch (response.getBody()) {
		case "SUCCESS":
			logger.info("success, rediredt: {}", bankAccountDTO.getSuccessUrl());
			return ResponseEntity.status(HttpStatus.OK).body(new String(bankAccountDTO.getSuccessUrl()));
		case "FAIL":
			logger.info("fail, redirect: {}", bankAccountDTO.getFailedUrl());
			return ResponseEntity.status(HttpStatus.OK).body(new String(bankAccountDTO.getFailedUrl()));
		default:
			logger.info("error, redirect: {}", bankAccountDTO.getErrorUrl());
			return ResponseEntity.status(HttpStatus.OK).body(new String(bankAccountDTO.getErrorUrl()));
		}
	}
}
