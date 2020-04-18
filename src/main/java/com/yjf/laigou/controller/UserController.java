package com.yjf.laigou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yjf.laigou.pojo.User;
import com.yjf.laigou.service.UserService;
import com.yjf.laigou.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
 
    @RequestMapping("admin_user_list")
    public String list(Model model, Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        //查找用户
        List<User> us= userService.list();

        int total = (int) new PageInfo<>(us).getTotal();
        page.setTotal(total);

        model.addAttribute("us", us);
        model.addAttribute("page", page);

        return "admin/listUser";
    }
    @RequestMapping("admin_user_add")
    public String add(User user){

        List<User> us= userService.list();//查找用户
        for (User s:us
        ) {
            if(s.getName().equalsIgnoreCase(user.getName())){

                return "admin/listUser";
            }
        }

        userService.add(user);

        return "redirect:/admin_user_list";
    }

}
