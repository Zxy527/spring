package com.itheima.demo;

import com.itheima.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

/**
 * @Author: zxy
 * @Date: 2022/4/1 - 04 - 01 - 8:36
 * @Description: com.itheima.demo
 * @version: 1.0
 */
public class UserDaoDemo {
    //这是一个main方法，程序的入口
    public static void main(String[] args) {
        //Spring 客户端代码
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        //用接口接收一下，我们知道这个是UserDao类型的，所以用UserDao接收
        UserDao userDao = (UserDao) app.getBean("userDao");
        userDao.save();
    }
}
