package com.medi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages="com.medi")
public class MedicalErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalErpApplication.class, args);
	}

}
