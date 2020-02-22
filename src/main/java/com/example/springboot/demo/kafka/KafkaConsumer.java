package com.example.springboot.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @author andrew
 * @date 2020/2/22 19:46
 */

@Slf4j
@Component
public class KafkaConsumer {
    @KafkaListener(groupId = "simpleGroup", topics = "aTopic1")
    public void consumer1(ConsumerRecord<String, Object> record,
                          @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, Consumer consumer) {
        log.info("Kafka消费成功,topic= {} ,content = {}", topic, record.value());

    }
}
