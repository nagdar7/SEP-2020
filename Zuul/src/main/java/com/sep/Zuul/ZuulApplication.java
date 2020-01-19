package com.sep.Zuul;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl.EurekaJerseyClientBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import com.netflix.discovery.DiscoveryClient.DiscoveryClientOptionalArgs;

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
	// public DiscoveryClientOptionalArgs discoveryClientOptionalArgs() throws
	// NoSuchAlgorithmException, IOException {
	// DiscoveryClientOptionalArgs args = new DiscoveryClientOptionalArgs();
	// System.setProperty("javax.net.ssl.keyStore", "src/main/resources/zuul.jks");
	// System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword);
	// System.setProperty("javax.net.ssl.trustStore",
	// "src/main/resources/zuul.jks");
	// System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
	// EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
	// builder.withClientName(name);
	// builder.withSystemSSLConfiguration();
	// builder.withMaxTotalConnections(10);
	// builder.withMaxConnectionsPerHost(10);
	// args.setEurekaJerseyClient(builder.build());
	// return args;
	// }

	// @Bean
	// public RestTemplate restTemplate(RestTemplateBuilder builder) throws
	// FileNotFoundException {
	// String allPassword = trustStorePassword;

	// SSLContext sslContext = SSLContextBuilder.create()
	// .loadKeyMaterial(ResourceUtils.getFile("classpath:keystore.jks"),
	// allPassword.toCharArray(),
	// allPassword.toCharArray())
	// .loadTrustMaterial(ResourceUtils.getFile("classpath:truststore.jks"),
	// allPassword.toCharArray())
	// .build();

	// HttpClient client = HttpClients.custom().setSSLContext(sslContext).build();

	// return builder.requestFactory(new
	// HttpComponentsClientHttpRequestFactory(client)).build();
	// }

}
