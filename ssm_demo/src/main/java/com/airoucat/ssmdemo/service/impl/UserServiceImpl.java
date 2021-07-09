package com.airoucat.ssmdemo.service.impl;

import com.airoucat.ssmdemo.mapper.UserMapper;
import com.airoucat.ssmdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.airoucat.ssmdemo.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.selectAll();
    }
}