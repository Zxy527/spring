package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

/**
 * @Author: zxy
 * @Date: 2022/4/8 - 04 - 08 - 9:56
 * @Description: com.itheima.service
 * @version: 1.0
 */
public interface UserService {
    List<User> list();

    void save(User user, Long[] roleIds);
}
