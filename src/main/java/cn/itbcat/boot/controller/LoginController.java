package cn.itbcat.boot.controller;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.utils.ITBC;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
            Session session = subject.getSession();
            if(null != userService.getUserByEmail(username))
            session.setAttribute("currentUser",userService.getUserByEmail(username));
            //设置会话的过期时间--ms,默认是30分钟，设置负数表示永不过期
            session.setTimeout(-1001);
            return "redirect:/";
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

    @RequestMapping(value = "/lock",method = RequestMethod.GET)
    public String lockMe(Map<String,Object> dataModel) {
        Subject subject = SecurityUtils.getSubject();
        User user = ITBC.getCurrUser();
        if(null == user){
            return "redirect:/login";
        }
        dataModel.put("username",user.getEmail());
        subject.logout();
        return "lockme";
    }
}
