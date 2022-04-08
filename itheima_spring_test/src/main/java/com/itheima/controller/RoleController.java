package com.itheima.controller;

import com.itheima.dao.UserDao;
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

    @RequestMapping("/save")
    public String save(Role role){//不需要存储数据所以返回一个String就行
        // roleName,roleDesc都是role对象属性，所以这里用role进行接收,就不要这样(String roleName,String roleDesc)了
        //通过执行roleService保存就行
        roleService.save(role);
       //现在要跳转到list地址,用重定向,数据添加后，要再次查询数据库里的数据，再显示所有数据，不能直接跳转到role-list.jsp页面，因为这个页面是没有数据的
        //必须先进行查询，才能显示所有数据
        return "redirect:/role/list";
    }
}
