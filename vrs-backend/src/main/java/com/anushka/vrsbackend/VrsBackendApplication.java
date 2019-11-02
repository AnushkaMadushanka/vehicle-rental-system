package com.anushka.vrsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.anushka.vrsbackend.controllers",
		"com.anushka.vrsbackend.abstracts",
		"com.anushka.vrsbackend.concretes"
})
public class VrsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VrsBackendApplication.class, args);
	}

}
