package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;

/**
 * @Author: zxy
 * @Date: 2022/4/1 - 04 - 01 - 10:59
 * @Description: com.itheima.factory
 * @version: 1.0
 */
public class DynamicFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
