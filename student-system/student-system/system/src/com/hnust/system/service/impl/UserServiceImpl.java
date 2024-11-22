package com.hnust.system.service.impl;

import com.hnust.system.mapper.UserMapper;
import com.hnust.system.mapper.impl.UserMapperImpl;
import com.hnust.system.pojo.User;
import com.hnust.system.service.UserService;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper = new UserMapperImpl();
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
