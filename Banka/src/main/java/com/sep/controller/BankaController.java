package com.sep.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sep.model.Banka;

@RequestMapping("/api")
@RestController
public class BankaController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(path = "/banka", method = RequestMethod.POST)
	public ResponseEntity Check(@RequestBody Banka user) {
		logger.debug("check validity of request before passing to acquirer, id: {}", user.getId());
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity("https://localhost:8005/api/aq", user,
				String.class);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
