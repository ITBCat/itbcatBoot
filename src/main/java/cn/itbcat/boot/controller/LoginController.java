package cn.itbcat.boot.controller;

import cn.itbcat.boot.config.webConfig;
import cn.itbcat.boot.entity.User;
import cn.itbcat.boot.service.UserService;
import cn.itbcat.boot.utils.ITBC;
import cn.itbcat.boot.utils.MD5;
import org.apache.shiro.crypto.hash.Sha256Hash;
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
    public String toLogin(String username, String password, HttpSession session, Map<String,Object> dataModel){

        User user = userService.getUserByEmail(username);

        if(user == null){
            dataModel.put("msg","用户不存在");
            return "login";
        }

        String pass = new Sha256Hash(password,MD5.encodeSHAString(ITBC.PRODUCT_NAME)).toHex().toString();

        if (!pass.equals(user.getPassword())){
            dataModel.put("msg","密码错误");
            return "login";
        }

        // 设置session
        session.setAttribute(webConfig.SESSION_KEY, userService.getUserByEmail(username));

        return "redirect:/admin";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(webConfig.SESSION_KEY);
        return "redirect:/login";
    }
}
