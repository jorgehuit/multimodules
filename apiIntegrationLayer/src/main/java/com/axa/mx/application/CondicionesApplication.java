package com.axa.mx.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;

import com.axa.mx.business.retry.impl.RemoteRetryImpl;

@SpringBootApplication(scanBasePackages = "com.axa.mx")
@EntityScan(basePackages = {"com.axa.mx.persistence.entity"})
@EnableJpaRepositories(basePackages = {"com.axa.mx.persistence.repository"})
@EnableFeignClients(basePackages = {"com.axa.mx.business.client"})
@Import(value = RemoteRetryImpl.class)
@EnableRetry()
public class CondicionesApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(CondicionesApplication.class, args);
    }
    
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CondicionesApplication.class);
	}
}
