package com.itheima.demo;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *假的
 */
public class UserController {
    //这是一个main方法，程序的入口
    public static void main(String[] args) {
//        UserService userService=new UserServiceImpl();control层调service层一般是这样的
//        userService.save();
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();

        //UserService userService=new UserServiceImpl();
        // userService.save();
        //这两句会报错，空指针异常，因为这里的userService是自己创建的，不是从容器里面拿的。虽然里面有一个userDao对象，
        // 但是并没有给它赋值null.save就会报错
    }
}
