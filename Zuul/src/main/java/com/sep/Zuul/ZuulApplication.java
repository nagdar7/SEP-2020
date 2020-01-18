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

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	// @Value("${server.ssl.key-store}")
	// private Resource keyStore;

	@Value("${server.ssl.key-store-password}")
	private String keyStorePassword;

	@Value("${server.ssl.trust-store-password}")
	private String trustStorePassword;

	@Value("${spring.application.name}")
	private String name;

	@Bean
	public DiscoveryClientOptionalArgs discoveryClientOptionalArgs() throws NoSuchAlgorithmException, IOException {
		DiscoveryClientOptionalArgs args = new DiscoveryClientOptionalArgs();
		System.setProperty("javax.net.ssl.keyStore", "src/main/resources/zuul.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword);
		System.setProperty("javax.net.ssl.trustStore", "src/main/resources/zuul.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
		EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
		builder.withClientName(name);
		builder.withSystemSSLConfiguration();
		builder.withMaxTotalConnections(10);
		builder.withMaxConnectionsPerHost(10);
		args.setEurekaJerseyClient(builder.build());
		return args;
	}

}
