package com.sep.Eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
@CrossOrigin
class EurekaDiscoveryController {

	@Autowired
	private DiscoveryClient discoveryClient;

	// @RequestMapping("/service-instances/{applicationName}")
    @RequestMapping(value = "api/service-instances/{applicationName}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
				List<ServiceInstance> list = discoveryClient.getInstances("STORES");
				List<String> result = new ArrayList<String>();
				System.out.println(list.get(0).toString());
				if (list != null && list.size() > 0 ) {
					result.add("Nasao");
				}
				return new ResponseEntity<String>("nesto", HttpStatus.OK);
				// return result;
		// return this.discoveryClient.getInstances(applicationName);
	}
}