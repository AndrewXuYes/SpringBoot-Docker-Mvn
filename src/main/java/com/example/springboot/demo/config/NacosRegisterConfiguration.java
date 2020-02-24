package com.example.springboot.demo.config;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author andrew
 * @date 2020/2/24 23:16
 */

@Configuration
@NacosPropertySource(dataId = "aConfig", autoRefreshed = true)
public class NacosRegisterConfiguration {

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @NacosValue(value = "${nacos.ip:118.89.155.112}")
    private String nacosIp;

    @NacosInjected
    private NamingService namingService;

    //  和Nacos注册服务
    @PostConstruct
    public void registerInstance() throws NacosException {
        namingService.registerInstance(applicationName, nacosIp, serverPort, "ThisisS2String");
    }

}
