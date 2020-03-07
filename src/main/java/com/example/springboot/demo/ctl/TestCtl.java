package com.example.springboot.demo.ctl;

import com.example.springboot.demo.aop.Justalog;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andrew
 * @date 2020/2/24 22:26
 */
@Log
@RestController
public class TestCtl {

    @ApiOperation("打招呼页面")
    @RequestMapping("/test")
    @Justalog
    public String sayHello0(String astr) {
        log.info("hello-test");
        log.info("打招呼页面");
        return "谢谢观看:这是test页面";
    }
}
