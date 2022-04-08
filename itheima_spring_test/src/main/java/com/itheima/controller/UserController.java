package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: zxy
 * @Date: 2022/4/8 - 04 - 08 - 9:52
 * @Description: com.itheima.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    //内部要想查询得通过service层
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    //添加用户信息
    @RequestMapping("/save")
    public String save(User user,Long []roleIds){
        //user接收的是用户名称，密码，邮箱，电话等用户信息
        //用户角色可以选择多个，所以这里用数组进行接收,roleIds必须和jsp中对应的名字一致
        //请求玩数据，保存后返回String就行，换句话说，就是进行重定向，重定向到列表页面
        userService.save(user,roleIds);
        return "redirect:/user/list";

    }

    //这里要查所有的用户角色（角色数据要角色服务去负责）（点击新建后，会要展示用户角色信息）
    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView=new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    //显示用户信息
    @RequestMapping("/list")
    public ModelAndView list(){
        List<User> userList=userService.list();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }


}
