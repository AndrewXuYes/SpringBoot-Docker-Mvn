package com.example.springboot.demo.ctl;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@Log
public class CtlOOM {


    @RequestMapping("/oom")
    public void oom() {
        int cnt = 30000000;
        long curTime = System.currentTimeMillis();
        Map<Integer, String> map = new HashMap<Integer, String>(cnt * 2);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            map.put(i, "Test" + i);

            if (i % 50 == 0) {
                for (int j = i - 45; j < i; j++) {
                    map.remove(j);
                }
            }

            if (i % 500000 == 0) {
                System.out.println("i=" + i + ", time=" + (System.currentTimeMillis() - curTime));
                curTime = System.currentTimeMillis();
            }
        }
    }
}
