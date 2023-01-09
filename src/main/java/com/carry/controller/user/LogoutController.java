package com.carry.controller.user;

import com.carry.service.user.UserService;
import com.carry.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LogoutController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @GetMapping("/jsp/logout.do")
    public void Logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //移除用户的Constants.USER_SESSION
        req.getSession().removeAttribute(Constants.USER_SESSION);
        resp.sendRedirect(req.getContextPath()+"/login.jsp");//返回登录页面
    }
}
