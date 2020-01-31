package com.sep.BitCoin;

import java.security.NoSuchAlgorithmException;

import com.netflix.discovery.DiscoveryClient.DiscoveryClientOptionalArgs;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl.EurekaJerseyClientBuilder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class BitCoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitCoinApplication.class, args);
	}

	// @Value("${server.ssl.key-store-password}")
	// private String keyStorePassword;

	// @Value("${server.ssl.trust-store-password}")
	// private String trustStorePassword;

	// @Value("${spring.application.name}")
	// private String name;

	// @Bean
	// public DiscoveryClientOptionalArgs discoveryClientOptionalArgs() throws
	// NoSuchAlgorithmException {
	// DiscoveryClientOptionalArgs args = new DiscoveryClientOptionalArgs();
	// System.setProperty("javax.net.ssl.keyStore",
	// "src/main/resources/bitcoin.jks");
	// System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword);
	// System.setProperty("javax.net.ssl.trustStore",
	// "src/main/resources/bitcoin.jks");
	// System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);
	// EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
	// builder.withClientName(name);
	// builder.withSystemSSLConfiguration();
	// builder.withMaxTotalConnections(10);
	// builder.withMaxConnectionsPerHost(10);
	// args.setEurekaJerseyClient(builder.build());
	// return args;
	// }

}
