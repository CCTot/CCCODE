package com.hnust.system.mapper.impl;

import com.hnust.system.mapper.BaseMapper;
import com.hnust.system.mapper.UserMapper;
import com.hnust.system.pojo.User;

import java.util.List;

public class UserMapperImpl extends BaseMapper implements UserMapper {
    @Override
    public User findByUsername(String username) {
        String sql = "select * from sys_user where username = ?";
        return (User) baseQuery(User.class, sql, username).get(0);
    }
}
