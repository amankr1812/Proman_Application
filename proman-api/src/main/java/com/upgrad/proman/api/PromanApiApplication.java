package com.upgrad.proman.api;

import com.upgrad.proman.service.ServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ServiceConfiguration.class)
@ComponentScan
public class PromanApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PromanApiApplication.class, args);
    }
}
