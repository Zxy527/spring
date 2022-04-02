package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    //set注入
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    //构造注入
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

    @Override
    public void save() {

        /*
        上面注入成功的话，下面文本注释里面的东西就不要了，不要从容器获得dao了，因为在容器内部就通过上面的set方法将dao注入给我了
        如果能注入的话userDao就不是空，就有值，这个值就是容器里的Dao，但是现在spring不知道，所以在配置文件中要告诉spring

        //userService要调UserDao，UserDao对象已经让spring产生了
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        //用接口接收一下，我们知道这个是UserDao类型的，所以用UserDao接收
        //UserDao dao=new UserDaoImpl();一般是这样的，
        UserDao userDao = (UserDao) app.getBean("userDao");*/
        userDao.save();//这里的usedao是上面的 private UserDao userDao中的
    }
}
