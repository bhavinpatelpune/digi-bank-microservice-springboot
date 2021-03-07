package com.demo.springbatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringbatchdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbatchdemoApplication.class, args);
	}

}
