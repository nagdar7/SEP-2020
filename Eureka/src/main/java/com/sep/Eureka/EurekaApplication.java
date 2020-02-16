package com.sep.Eureka;

import java.security.NoSuchAlgorithmException;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.transport.jersey.EurekaJerseyClientImpl.EurekaJerseyClientBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

	// @Autowired
	// private Environment env;

	// @Bean
	// public DiscoveryClient.DiscoveryClientOptionalArgs
	// discoveryClientOptionalArgs() throws NoSuchAlgorithmException {
	// System.setProperty("https.protocols", "TLSv1.2");

	// DiscoveryClient.DiscoveryClientOptionalArgs args = new
	// DiscoveryClient.DiscoveryClientOptionalArgs();
	// System.setProperty("javax.net.ssl.keyStore",
	// "src/main/resources/localhost.p12");
	// System.setProperty("javax.net.ssl.keyStorePassword",
	// env.getProperty("server.ssl.key-store-password"));

	// // System.setProperty("javax.net.ssl.trustStore",
	// // env.getProperty("server.ssl.trust-store"));
	// // System.setProperty("javax.net.ssl.trustStorePassword",
	// // env.getProperty("server.ssl.trust-store-password"));
	// EurekaJerseyClientBuilder builder = new EurekaJerseyClientBuilder();
	// builder.withClientName("account-client");
	// builder.withSystemSSLConfiguration();
	// builder.withMaxTotalConnections(10);
	// builder.withMaxConnectionsPerHost(10);
	// args.setEurekaJerseyClient(builder.build());
	// return args;
	// }

}
