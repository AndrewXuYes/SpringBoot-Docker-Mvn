package com.example.springboot.demo.Ctl;

import com.example.springboot.demo.Dto.User;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class CtlHello {


    @ApiOperation("删除用户1")
    @RequestMapping("/hello1")
    public String sayHello(String astr) {
        log.info("hello1");
        return "谢谢观看:" + astr;
    }

    @RequestMapping("/hello2")
    public String sayHello2(@Validated User user) {
        log.info("hello2");
        return "谢谢观看" + user.getName();
    }


}
