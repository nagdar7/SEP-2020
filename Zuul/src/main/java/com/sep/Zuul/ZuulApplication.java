package com.sep.Zuul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl.EurekaJerseyClientBuilder;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.netflix.discovery.DiscoveryClient.DiscoveryClientOptionalArgs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	// @Value("${server.ssl.key-store}")
	// private Resource keyStore;

	// @Value("${server.ssl.key-store-password}")
	// private String keyStorePassword;

	// @Value("${server.ssl.trust-store-password}")
	// private String trustStorePassword;

	// @Value("${spring.application.name}")
	// private String name;

	// @Bean
	// public DiscoveryClientOptionalArgs discoveryClientOptionalArgs() throws NoSuchAlgorithmException, IOException {
	// 	DiscoveryClientOptionalArgs args = new DiscoveryClientOptionalArgs();
	// 	System.setProperty("javax.net.ssl.keyStore", "src/main/resources/zuul.jks");
	// 	System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword);
	// 	System.setProperty("javax.net.ssl.trustStore", "src/main/resources/zuul.jks");
	// 	System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
	// 	EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
	// 	builder.withClientName(name);
	// 	builder.withSystemSSLConfiguration();
	// 	builder.withMaxTotalConnections(10);
	// 	builder.withMaxConnectionsPerHost(10);
	// 	args.setEurekaJerseyClient(builder.build());
	// 	return args;
	// }

}

@RestController
@CrossOrigin
class EurekaDiscoveryController {

	// @Autowired
	// private DiscoveryClient discoveryClient;

	// @RequestMapping("/service-instances/{applicationName}")
    // @RequestMapping(value = "api/service-instances/{applicationName}", method = RequestMethod.GET,
    //         produces = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<String> serviceInstancesByApplicationName(
	// 		@PathVariable String applicationName) {
	// 			List<ServiceInstance> list = discoveryClient.getInstances("STORES");
	// 			List<String> result = new ArrayList<String>();
	// 			System.out.println(list.get(0).toString());
	// 			if (list != null && list.size() > 0 ) {
	// 				result.add("Nasao");
	// 			}
	// 			return new ResponseEntity<String>("nesto", HttpStatus.OK);
	// 			// return result;
	// 	// return this.discoveryClient.getInstances(applicationName);
	// }

	@RequestMapping(value = "/api/getServices/{applicationName}", method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPaymentMethods(@PathVariable String applicationName) {
		// logger.debug("Get all services");
        System.out.println("Dosao sam do slanjaaaaaaa!");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8761/api/service-instances/"+applicationName, String.class);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
