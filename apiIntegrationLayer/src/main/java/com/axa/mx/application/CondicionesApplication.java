package com.axa.mx.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.axa.mx")
@EntityScan(basePackages = {"com.axa.mx.persistence.entity"})
@EnableJpaRepositories(basePackages = {"com.axa.mx.persistence.repository"})
@EnableFeignClients(basePackages = {"com.axa.mx.business.client"})
public class CondicionesApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(CondicionesApplication.class, args);
    }
    
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CondicionesApplication.class);
	}
}
