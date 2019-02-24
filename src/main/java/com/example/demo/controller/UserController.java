package com.example.demo.controller;

import com.example.demo.common.ServerResponse;
import com.example.demo.pojo.MmallUser;
import com.example.demo.service.MmallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by rabbit on 2019/2/24.
 */
@RestController
@RequestMapping("/mybatis")
public class UserController {

    @Autowired
    private MmallUserService mmallUserService;

    @RequestMapping("user/add")
    public ServerResponse saveUser(){
        MmallUser user = new MmallUser();
        user.setId(100000);
        user.setUsername("BERIO");
        user.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        user.setEmail("1234567891@qq.com");
        user.setPhone("12345678911");
        user.setQuestion("问题");
        user.setAnswer("答案");
        user.setRole(1);
        mmallUserService.addUser(user);
        return ServerResponse.createBySuccessAndMsg("用户保存成功!");
    }

    @RequestMapping("user/update/{id}")
    public ServerResponse updateUser(@PathVariable Integer id){
        MmallUser user = new MmallUser();
        user.setId(id);
        user.setUsername("BEHE");
        user.setPassword(DigestUtils.md5DigestAsHex("654321".getBytes()));
//        mmallUserService.updateUser(user);
        mmallUserService.updateUserBySelective(user);
        return ServerResponse.createBySuccessAndMsg("用户信息修改成功!");
    }

    @RequestMapping("user/delete/{id}")
    public ServerResponse deleteUser(@PathVariable Integer id){
        mmallUserService.deleteUserByPrimaryId(id);
        return ServerResponse.createBySuccessAndMsg("成功删除指定用户!");
    }


    @RequestMapping("user/list")
    public ServerResponse<List<MmallUser>> queryUserByList(Integer pageNum){
        if(pageNum == null){
            pageNum = 1;
        }
        int pageSize = 2;
        return ServerResponse.createBySuccess(mmallUserService.queryUserByList(null, pageNum, pageSize));
    }

}
