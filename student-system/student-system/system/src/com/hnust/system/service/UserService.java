package com.hnust.system.service;

import com.hnust.system.pojo.User;

public interface UserService {

    /**
     * 根据用户登录输入的用户名查找用户信息
     * @param username 输入的用户名
     * @return 返回一个账户对象
     */
    User findByUsername(String username);
}
