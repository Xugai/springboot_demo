package com.example.demo.controller;

import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.MmallUser;
import com.example.demo.service.MmallUserService;
import com.example.demo.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Created by rabbit on 2019/3/3.
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private MmallUserService mmallUserService;

    @RequestMapping("test")
    public ServerResponse testRedis() throws JsonProcessingException, IOException{
        List<MmallUser> userList =  mmallUserService.queryUserByList(null, 1, 2);
        ObjectMapper objectMapper = new ObjectMapper();
        if(userList.size() > 0){
            MmallUser user = userList.get(0);
            strRedis.opsForValue().set("json:user", objectMapper.writeValueAsString(user));
        }

        MmallUser user = objectMapper.readValue(strRedis.opsForValue().get("json:user"), MmallUser.class);
        return ServerResponse.createBySuccess(user);
    }

    @RequestMapping("test/util")
    public ServerResponse testRedisUtil() throws JsonProcessingException, IOException{
        List<MmallUser> userList =  mmallUserService.queryUserByList(null, 1, 2);
        ObjectMapper objectMapper = new ObjectMapper();
        if(userList.size() > 0){
            MmallUser user = userList.get(0);
            redisUtil.set("json:new:user", objectMapper.writeValueAsString(user));
        }

        MmallUser user = objectMapper.readValue(redisUtil.get("json:new:user"), MmallUser.class);
        return ServerResponse.createBySuccess(user);

    }
}
