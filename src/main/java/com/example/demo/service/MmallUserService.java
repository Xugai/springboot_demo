package com.example.demo.service;

import com.example.demo.pojo.MmallUser;

import java.util.List;

/**
 * Created by rabbit on 2019/2/24.
 */
public interface MmallUserService {
    void addUser(MmallUser user);

    void deleteUserByPrimaryId(Integer id);

    void updateUser(MmallUser user);

    void updateUserBySelective(MmallUser user);

    List<MmallUser> queryUserByList(MmallUser user, Integer pageNum, Integer pageSize);
}
