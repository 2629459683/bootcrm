package com.dnsoft.bootcrm.core.web.controller;

import com.dnsoft.bootcrm.core.pojo.User;
import com.dnsoft.bootcrm.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    //依赖注入
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.action",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    //用户登录
    @RequestMapping(value = "/login.action",method = RequestMethod.POST)
    public String login(String usercode, String password, Model model, HttpSession httpSession){
        //通过账号和密码查询用户
        User user = userService.findUser(usercode,password);

        if(user != null){
            //将用户对象添加到session
            httpSession.setAttribute("USER_SESSION",user);
            //跳转到主页
            return "redirect:toCustomer.action";
        }

        model.addAttribute("msg","用户名或密码错误，请重新输入！");

        //返回到登录页面
        return "login";
    }
}
