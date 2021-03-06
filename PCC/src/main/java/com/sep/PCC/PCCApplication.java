package com.sep.PCC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sep")
public class PCCApplication {

	public static void main(String[] args) {
		SpringApplication.run(PCCApplication.class, args);
	}

}
