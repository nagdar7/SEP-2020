package com.sep.BitCoin.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sep.BitCoin.model.BitCoin;
import com.sep.BitCoin.model.FormField;
import com.sep.BitCoin.model.Order;
import com.sep.BitCoin.model.OrderResponse;
import com.sep.BitCoin.model.RedirectDTO;
import com.sep.BitCoin.service.BitCoinService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class BitCoinServiceImpl implements BitCoinService {

	@Value("${coingate.url}")
	String coingateUrl;

	@Value("${coingate.token}")
	String coingateToken;

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<BitCoin> returnAllAccounts() {
		log.info("returnAllAccounts");
		List<BitCoin> accounts = new ArrayList<BitCoin>();
		accounts.add(new BitCoin(1L, "1234", "1234568789546", 20000.00, "Petar", "Petrovic"));
		accounts.add(new BitCoin(1L, "5678", "1567894654984", 30000.00, "Mika", "Mikic"));
		accounts.add(new BitCoin(1L, "9012", "8464816886885", 40000.00, "Milan", "Milanovic"));
		accounts.add(new BitCoin(1L, "3456", "7486595153266", 50000.00, "Jovan", "Jovanovic"));
		accounts.add(new BitCoin(1L, "7890", "8941684168461", 70000.00, "Test", "Test"));
		accounts.add(new BitCoin(1L, "1456", "8527419685456", 60000.00, "Dragan", "Vujanovic"));
		accounts.add(new BitCoin(1L, "1598", "7418521265478", 90000.00, "Tatjana", "Zdravkovic"));
		return accounts;
	}

	@Override
	public List<FormField> getFormFieldsForBitcoin() {
		log.info("getFormFieldsForBitcoin");
		List<FormField> formFields = new ArrayList<FormField>();
		formFields.add(new FormField("total", "Total (EUR)", "number", false));
		// formFields.add(new FormField("currency", "Currency", "string", false));
		return formFields;
	}

	@Override
	public RedirectDTO pay(Map<String, String> items) {
		log.info("pay, items: {}", items);
		RedirectDTO redirectDTO = new RedirectDTO();
		redirectDTO.setStatus("error");

		Order order = new Order();
		try {
			order.setPriceAmount(Double.parseDouble(items.get("total")));
		} catch (Exception e) {
			return redirectDTO;
		}
		order.setPriceCurrency("EUR");
		order.setReceiveCurrency("BTC");
		order.setCancelUrl(items.get("failedUrl"));
		order.setSuccessUrl(items.get("successUrl"));

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		// headers.add("Content-Type", "application/x-www-form-urlencoded");
		headers.add("Authorization", "Token " + coingateToken);
		HttpEntity<Order> entity = new HttpEntity<>(order, headers);

		// Create order
		try {
			ResponseEntity<OrderResponse> orderResponse = restTemplate.postForEntity(coingateUrl + "/orders", entity,
					OrderResponse.class);
			if (orderResponse.hasBody() && orderResponse.getStatusCode().equals(HttpStatus.OK)) {
				log.info("order passed");
				redirectDTO.setStatus("success");
				redirectDTO.setRedirectUrl(orderResponse.getBody().getPaymentUrl());
			} else {
				log.warn("body not found or status code not ok, body: {}, statusCode: {}", orderResponse.getBody(),
						orderResponse.getStatusCode());
			}
		} catch (RestClientException rce) {
			log.error("error while sending request to coingate", rce);
		}
		return redirectDTO;
	}
}
