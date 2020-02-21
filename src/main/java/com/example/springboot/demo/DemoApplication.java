package com.example.springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springboot.demo.mapper")
public class DemoApplication {

    // mvn clean package
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
