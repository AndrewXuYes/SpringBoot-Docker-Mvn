package com.example.springboot.demo.ctl;


import com.example.springboot.demo.aop.Justalog;
import com.example.springboot.demo.server.TestServer;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class TestCtl {

    @Autowired
    TestServer testServer;

    @ApiOperation("test")
    @RequestMapping("/test")
    @Justalog
    public String test() {
        log.info("hello1");
        String astr = testServer.listAll();
        return astr;
    }
}
