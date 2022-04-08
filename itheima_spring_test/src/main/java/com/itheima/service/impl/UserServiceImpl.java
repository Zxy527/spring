package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.UserService;

import java.util.List;

/**
 * @Author: zxy
 * @Date: 2022/4/8 - 04 - 08 - 9:58
 * @Description: com.itheima.service.impl.impl
 * @version: 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    //用配置文件进行配置，不用注解，所以这里要又set方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {//这里要想注入进去，还得配置文件
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
      //  return userDao.findAll();
        //为某一个用户查询当前具备得角色
        List<User> userList = userDao.findAll();
        //这里得到了user表中的信息（id,name,email,phone），但是并不知道每个用户对应的角色,所以接下来可以根据这里所得的id
        // 来查user-role，再根据这个中间表，查询role表，就可得到用户对应的角色数据信息
        //封装userList中的每一个user的roles数据
        for (User user : userList) {
            //取出每个user的id
            Long id = user.getId();
            //将id作为参数，查询当前userId对应的Role的集合数据,这里查role，方法放到role的模块当中，role的dao中，上面对应roledao对象
            List<Role> roles =userDao.findRoleByUserId(id);
            //得到数据后，用当前user进行封装
            user.setRoles(roles);//那么现在每个user当中的roles就有数据了
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //第一步，向sys_user表存数据
        Long userId=userDao.save(user);
        //第二步，向sys_user_role关系表中存储多个数据
        userDao.saveUserRoleRel(userId,roleIds);
    }
}
