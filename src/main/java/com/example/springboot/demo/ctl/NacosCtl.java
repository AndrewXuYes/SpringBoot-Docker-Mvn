package com.example.springboot.demo.ctl;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andrew
 * @date 2020/2/25 1:02
 */

@Log
@RestController
public class NacosCtl {

    @NacosValue(value = "${nacos.ip}")
    private String nacosIp;

    @RequestMapping("/test")
    public String test(String name) {
        log.info("nacosIp==" + nacosIp);
        return nacosIp;
    }

}
