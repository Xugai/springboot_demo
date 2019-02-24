package com.example.demo.mapper;

import com.example.demo.pojo.MmallUser;
import com.example.demo.utils.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface MmallUserMapper extends MyMapper<MmallUser> {
    int addUser(MmallUser user);

}