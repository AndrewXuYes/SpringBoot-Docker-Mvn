package com.example.springboot.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ctl {

    @RequestMapping("*")
    public String sayHello() {
        System.out.println("sayHello");
        return "谢谢观看";
    }
}
