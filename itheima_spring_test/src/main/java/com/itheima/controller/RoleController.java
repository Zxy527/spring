package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: zxy
 * @Date: 2022/4/7 - 04 - 07 - 19:06
 * @Description: com.itheima.controller
 * @version: 1.0
 */
@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;
    //要注入，先用配置文件的方式，后期用注解方式(上面加了注解后，就可以省掉下面的了)
//    public void setRoleService(RoleService roleService) {
//        this.roleService = roleService;
//    }

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView=new ModelAndView();
        List<Role> roleList=roleService.list();

        //设置模型对象
        modelAndView.addObject("roleList",roleList);
        //设置视图
        modelAndView.setViewName("role-list");
        return  modelAndView;

    }
}
