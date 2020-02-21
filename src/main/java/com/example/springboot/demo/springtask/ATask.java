package com.example.springboot.demo.springtask;

import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@Log
public class ATask {
    /**
     * cron表达式：Seconds Minutes Hours Day Month DayofWeek [Year]
     */
    @Scheduled(cron = "*/20 * * * * ?")
    private void cancelTimeOutOrder() {
        log.info("这是个定时器");
    }
}