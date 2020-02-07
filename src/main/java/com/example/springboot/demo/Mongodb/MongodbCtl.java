package com.example.springboot.demo.Mongodb;

import com.example.springboot.demo.Dto.User;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController

public class MongodbCtl {

    @Autowired
    private MongoTemplate mongoTemplate;

    @ApiOperation("mongodb")
    @RequestMapping("/mongodb")
    public String mongodb() {
        log.info("mongodb！");

        User user = new User();
        user.setName("凌康");
        mongoTemplate.insert(user);
        user.setName("李白");
        mongoTemplate.insert(user);

        log.info("插入成功！");
        return "mongodbbbbb";
    }
}
