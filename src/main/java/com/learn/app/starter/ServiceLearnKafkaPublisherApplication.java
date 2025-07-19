package com.learn.app.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.learn.app")
public class ServiceLearnKafkaPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceLearnKafkaPublisherApplication.class, args);
	}

}
