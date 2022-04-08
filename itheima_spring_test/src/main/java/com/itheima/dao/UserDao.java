package com.itheima.dao;

import com.itheima.domain.Role;
import com.itheima.domain.User;

import java.util.List;

/**
 * @Author: zxy
 * @Date: 2022/4/8 - 04 - 08 - 10:00
 * @Description: com.itheima.dao
 * @version: 1.0
 */
public interface UserDao {
    List<User> findAll();
    List<Role> findRoleByUserId(Long id);

    Long save(User user);

    void saveUserRoleRel(Long id, Long[] roleIds);
}
