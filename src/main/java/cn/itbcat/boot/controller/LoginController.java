package cn.itbcat.boot.controller;

import cn.itbcat.boot.config.webConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 860117030 on 2017/9/11.
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    public String login(String username,String password){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String toLogin(String username,String password, HttpSession session){
        // 设置session
        session.setAttribute(webConfig.SESSION_KEY, username);

        return "redirect:/admin";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(webConfig.SESSION_KEY);
        return "redirect:/login";
    }
}
