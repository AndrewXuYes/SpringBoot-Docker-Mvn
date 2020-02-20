package com.example.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    // mvn clean package docker:build
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
