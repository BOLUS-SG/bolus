package com.bolus.backend.development.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.annotation.RequestScope;

import com.bolus.backend.development.ErrorHandling.ResponseDetails;

@SpringBootApplication
@Configuration
@ComponentScan({ "com.bolus.backend.development" })
@EnableJpaRepositories(basePackages = { "com.bolus.backend.development.admin.dao.repository",
		"com.bolus.backend.development.validation.dao.repository" })
@EntityScan(basePackages = { "com.bolus.backend.development" })
@EnableAutoConfiguration
public class BolusDevAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(BolusDevAdminApplication.class, args);
	}

	@Bean
	@RequestScope
	public ResponseDetails responseDetails() {
		return new ResponseDetails();
	}
}
