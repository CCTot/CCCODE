package com.hnust.system.mapper;

import com.hnust.system.pojo.User;

public interface UserMapper {
    /**
     * 根据用户名查找账户
     * @param username 输入的用户名
     * @return 返回查询的对象
     */
    User findByUsername(String username);
}
