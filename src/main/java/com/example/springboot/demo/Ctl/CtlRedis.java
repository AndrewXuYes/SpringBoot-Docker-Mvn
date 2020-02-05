package com.example.springboot.demo.Ctl;

import cn.hutool.core.util.StrUtil;
import com.example.springboot.demo.Redis.RedisUtils;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@Log
public class CtlRedis {

    @Autowired
    private RedisUtils redisUtils;
    private static final int TIMEOUT = 10 * 10000;

    @Valid
    @Min(value = 0, message = "控制库存最小为0")
    private int nums = 20;

    @RequestMapping("/redis")
    public String sayHello3() {

        // 线程1
        Thread t1 = new Thread(() -> {
            long time = System.currentTimeMillis() + TIMEOUT;
            for (int i = 0; i < 10; i++) {
                try {
                    redisUtils.lock("testkey", StrUtil.toString(time));
                    if (nums > 0) nums--;
                    log.info("t1=" + nums);
                    redisUtils.unlock("testkey", StrUtil.toString(time));
                } catch (Exception e) {
                    log.info("t1抢失败");
                }
            }
        }, "t1");

        // 线程2
        Thread t2 = new Thread(() -> {
            long time = System.currentTimeMillis() + TIMEOUT;
            for (int i = 0; i < 13; i++) {
                try {
                    redisUtils.lock("testkey", StrUtil.toString(time));
                    if (nums > 0) nums--;
                    log.info("t2=" + nums);
                    redisUtils.unlock("testkey", StrUtil.toString(time));
                    Thread.sleep(100);
                } catch (Exception e) {
                    log.info("t2抢失败");
                }
            }

        }, "t2");

        t1.start();
        t2.start();

        return "测试开始";

    }
}
