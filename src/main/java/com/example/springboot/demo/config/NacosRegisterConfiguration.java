package com.example.springboot.demo.config;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;

/**
 * @author andrew
 * @date 2020/2/24 23:16
 */

@Configuration
@NacosPropertySource(dataId = "aConfig", autoRefreshed = true)
public class NacosRegisterConfiguration {


}
