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

import com.netflix.eureka.EurekaServerContext;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import com.netflix.eureka.registry.PeerAwareInstanceRegistryImpl;
import com.netflix.discovery.shared.Applications;

@RestController
@CrossOrigin
class EurekaDiscoveryController {

	@Autowired
	private DiscoveryClient discoveryClient;

    @RequestMapping(value = "api/service-instances/{applicationName}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {

				List<String> result = new ArrayList<String>();
				PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
				Applications applications = registry.getApplications();

				applications.getRegisteredApplications().forEach((registeredApplication) -> {
					registeredApplication.getInstances().forEach((instance) -> {
						System.out.println(instance.getAppName() + " (" + instance.getInstanceId() + ") : ");
						if(!(instance.getAppName().toUpperCase().equals("ZUUL") || instance.getAppName().toUpperCase().equals("EUREKA") || instance.getAppName().toUpperCase().equals("SELLERS"))){
							result.add(instance.getAppName());
						}
					});
				});
				System.out.println(result.size());
				//treba da se vrati lista imena instance (instance.getAppName())
				//i to onda na naucnoj centrali ispisati kao check box i na osnovu toga cekirati
				//ne treba zuul samo pay pal videti kako to da se dinamicki izuzme
				return new ResponseEntity<List<String>>(result, HttpStatus.OK);
	}
}