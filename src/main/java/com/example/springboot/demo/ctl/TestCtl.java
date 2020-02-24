package com.example.springboot.demo.ctl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.springboot.demo.service.TestService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author andrew
 * @date 2020/2/24 22:26
 */
@Log
@RestController
public class TestCtl {

    @Autowired
//    @Reference
    private TestService testService;


    @RequestMapping("/test")
    public String sayHello0(@RequestParam("name") String name) {
        log.info("hello-test==" + testService.get(name));
        return testService.get(name);
    }
}
