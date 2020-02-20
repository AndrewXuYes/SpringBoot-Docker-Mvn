package com.example.springboot.demo;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAdminServer
public class DemoApplication {

    // mvn clean package docker:build
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}
