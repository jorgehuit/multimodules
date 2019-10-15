package com.axa.mx.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axa.mx.component.MyService;
import com.axa.mx.entity.UserExa;
import com.axa.mx.repository.UserExaRepository;

@SpringBootApplication(scanBasePackages = "com.axa.mx")
@EntityScan(basePackages = {"com.axa.mx.entity"})
@EnableJpaRepositories(basePackages = {"com.axa.mx.repository"})
@RestController
public class CondicionesApplication {

    private final MyService myService;
    
    @Autowired
    private UserExaRepository userExaRepository;

    public CondicionesApplication(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/")
    public String home() {
        return myService.message() + userExaRepository.findById(10002L).get().getUsername();
    }

    public static void main(String[] args) {
        SpringApplication.run(CondicionesApplication.class, args);
    }
}
