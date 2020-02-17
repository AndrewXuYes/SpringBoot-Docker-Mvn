package com.example.springboot.demo.mbg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.springboot.demo.mbg.mapper")
public class MyBatisConfig {
}