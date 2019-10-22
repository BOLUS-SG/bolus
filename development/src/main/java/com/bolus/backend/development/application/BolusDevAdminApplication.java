package com.bolus.backend.development.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan({"com.bolus.backend.development"})
@EnableJpaRepositories(basePackages = {"com.bolus.backend.development.admin.dao.repository"})
@EntityScan(basePackages = {"com.bolus.backend.development.employee.model","com.bolus.backend.development.admin.model"})
@EnableAutoConfiguration
public class BolusDevAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(BolusDevAdminApplication.class,args);
	}
}
