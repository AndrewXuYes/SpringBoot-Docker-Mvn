package com.example.springboot.demo.kafka;


import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

/**
 * @author liBai
 * @Classname MsgProducer
 * @Description TODO
 * @Date 2019-05-14 17:08
 */
@Slf4j
@Component
@EnableScheduling
public class MsgProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Scheduled(cron = "0/30 * * * * ?")
    public void send1() {
        String message = StrUtil.toString(Math.random());
        ListenableFuture listenableFuture = kafkaTemplate.send("aTopic1", message);
        listenableFuture.addCallback(
                msg -> log.info("消息发送成功,{}", msg.toString()),
                throwable -> log.info("消息发送失败,{}" + throwable.getMessage())
        );
    }
}
