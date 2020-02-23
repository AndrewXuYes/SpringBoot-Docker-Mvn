package com.example.springboot.demo.ctl;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author andrew
 * @date 2020/2/22 21:30
 */
@Log
@RestController
public class NacosCtl {

    @NacosInjected
    private NamingService namingService;

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/getOrder")
    @ResponseBody
    private String queryUserName() {
        try {
            if (namingService != null) {
                // 选择user_service服务的一个健康的实例（可配置负载均衡策略）
                Instance instance = namingService.selectOneHealthyInstance("PmsBrandService");
                // 拼接请求接口url并请求选取的实例
                String url = "http://" + instance.getIp() + ":" + instance.getPort() + "/getUser";
                ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
                return entity.getBody();
            }
        } catch (Exception e) {
            log.info("query user error" + e);
        }
        return null;
    }

}

