package com.itheima.dao;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @Author: zxy
 * @Date: 2022/4/7 - 04 - 07 - 19:44
 * @Description: com.itheima.dao
 * @version: 1.0
 */
public interface RoleDao {
    public List<Role> findAll();
}
