package com.example.springboot.demo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.springboot.demo.service.TestService;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String get() {
        return "TestServiceImpl";
    }
}