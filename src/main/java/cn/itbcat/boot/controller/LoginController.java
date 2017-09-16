package cn.itbcat.boot.controller;

import cn.itbcat.boot.config.webConfig;
import cn.itbcat.boot.entity.User;
import cn.itbcat.boot.service.UserService;
import cn.itbcat.boot.utils.ITBC;
import cn.itbcat.boot.utils.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/11.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String toLogin(String username, String password, Map<String,Object> dataModel){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            return "redirect:/admin";
        } catch (AuthenticationException e) {
            dataModel.put("msg", e.getMessage());
        }
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        User user = ITBC.getCurrUser();
        subject.logout();
        return "redirect:/login";
    }
}
