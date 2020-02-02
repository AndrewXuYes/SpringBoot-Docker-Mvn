package com.example.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class DemoApplication {

    // mvn clean package docker:build
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}
