package cn.itbcat.boot.controller;

import cn.itbcat.boot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by 860117030 on 2017/9/12.
 */
@Controller
public class RegisterController {

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String toRegister(String username, String password, HttpSession session){

        return "redirect:/admin";
    }
}
