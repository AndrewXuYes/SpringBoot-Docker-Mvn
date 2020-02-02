package com.example.springboot.demo;

import lombok.extern.java.Log;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class Ctl {

    @RequestMapping("/hello")
    public String sayHello(@Validated User user) {
        log.info("hello");
        return "谢谢观看" + user.getName();
    }

    @RequestMapping("/hello2")
    public String sayHello2(User user) {
        log.info("hello");
        return "谢谢观看" + user.getName();
    }
}
