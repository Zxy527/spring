package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;

import java.util.List;

/**
 * @Author: zxy
 * @Date: 2022/4/7 - 04 - 07 - 19:43
 * @Description: com.itheima.service.impl
 * @version: 1.0
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        List<Role> roleList=roleDao.findAll();
        return roleList;
    }
}
