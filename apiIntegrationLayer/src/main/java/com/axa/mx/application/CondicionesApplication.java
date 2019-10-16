package com.axa.mx.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.axa.mx")
@EntityScan(basePackages = {"com.axa.mx.persistence.entity"})
@EnableJpaRepositories(basePackages = {"com.axa.mx.persistence.repository"})
public class CondicionesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CondicionesApplication.class, args);
    }
}
