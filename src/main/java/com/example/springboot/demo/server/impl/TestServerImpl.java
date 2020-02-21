package com.example.springboot.demo.server.impl;


import com.example.springboot.demo.server.TestServer;
import org.springframework.stereotype.Service;

@Service
public class TestServerImpl implements TestServer {

    @Override
    public String listAll() {
        return "TestYes";
    }

}
