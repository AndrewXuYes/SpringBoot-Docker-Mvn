package com.example.springboot.demo.service.impl;

import com.example.springboot.demo.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String get() {
        return "IamTestServiceImpl";
    }
}