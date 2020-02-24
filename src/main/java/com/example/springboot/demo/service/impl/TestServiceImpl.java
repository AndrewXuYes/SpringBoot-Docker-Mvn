package com.example.springboot.demo.service.impl;

import com.example.springboot.demo.service.TestService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service
@Component
public class TestServiceImpl implements TestService {

    @Override
    public String get(String aname) {
        return "IamTestServiceImpl";
    }
}