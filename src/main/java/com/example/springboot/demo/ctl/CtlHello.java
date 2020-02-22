package com.example.springboot.demo.ctl;

import com.example.springboot.demo.aop.Justalog;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class CtlHello {


    @ApiOperation("打招呼页面")
    @RequestMapping("/")
    @Justalog
    public String sayHello0(String astr) {
        log.info("hello001");
        return "谢谢观看:这是初始化页面";
    }

}
