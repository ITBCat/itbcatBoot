package cn.itbcat.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 860117030 on 2017/9/11.
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"/login","/toLogin"})
    public String login(String username,String password){

        return "";
    }
}
