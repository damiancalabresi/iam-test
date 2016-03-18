package com.dcalabresi.iamtest;

import com.mangofactory.swagger.plugin.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableSwagger
@EnableScheduling
public class IamTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamTestApplication.class, args);
	}
}
