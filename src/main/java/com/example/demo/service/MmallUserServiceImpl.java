package com.example.demo.service;

import com.example.demo.mapper.MmallUserMapper;
import com.example.demo.pojo.MmallUser;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by rabbit on 2019/2/24.
 */
@Service("mmallUserService")
public class MmallUserServiceImpl implements MmallUserService {

    @Autowired
    private MmallUserMapper mmallUserMapper;

    @Override
    public void addUser(MmallUser user) {
        mmallUserMapper.addUser(user);
    }

    @Override
    public void deleteUserByPrimaryId(Integer id) {
        mmallUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUser(MmallUser user) {
        mmallUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public void updateUserBySelective(MmallUser user) {
        mmallUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<MmallUser> queryUserByList(MmallUser user, Integer pageNum, Integer pageSize) {
//        return mmallUserMapper
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(MmallUser.class);
        Example.Criteria criteria = example.createCriteria();

        List<MmallUser> mmallUserList = mmallUserMapper.selectByExample(example);

        return mmallUserList;
    }
}
