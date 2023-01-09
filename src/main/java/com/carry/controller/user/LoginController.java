package com.carry.controller.user;

import com.carry.pojo.User;
import com.carry.service.user.UserService;
import com.carry.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping("/login.do")
    public String Login(String userCode, String userPassword, HttpServletRequest req){
        System.out.println("LoginServlet--start...");

        //和数据库中的密码进行对比，调用业务层
        User user = userService.login(userCode, userPassword);

        if (user!=null && userPassword.equals(user.getUserPassword())){
            //将用户的信息放到Session中；
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            //跳转到主页
            return "redirect:/jsp/frame.jsp";
        }else {//查无此人，无法登陆
            //转发回登录界面，顺带提示，用户名或密码错误
            req.setAttribute("error","用户名或者密码错误！");
            return "../login";
        }
    }
}
