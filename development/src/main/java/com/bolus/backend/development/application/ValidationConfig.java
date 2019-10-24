package com.bolus.backend.development.application;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationConfig {

	@Bean
	public ValidatorFactory validatorFactory() {
		return Validation.buildDefaultValidatorFactory();
	}
}
