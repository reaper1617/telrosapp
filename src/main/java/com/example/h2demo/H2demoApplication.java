package com.example.h2demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class H2demoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(H2demoApplication.class, args);
    }

}
