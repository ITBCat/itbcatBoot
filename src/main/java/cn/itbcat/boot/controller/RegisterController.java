package cn.itbcat.boot.controller;

import cn.itbcat.boot.entity.User;
import cn.itbcat.boot.service.UserService;
import cn.itbcat.boot.utils.ITBC;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/12.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String toRegister(HttpServletRequest request, Map<String,Object> data){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password) && StringUtils.isNotBlank(repassword)){
            if(!password.equals(repassword)){
                data.put("msg","密码不一致");
                return "register";
            }
            User user = new User();
            user.setEmail(username);
            user.setUsername("front member");
            user.setIsAdmin(ITBC.NOT_ADMIN);
            user.setDeptName("");
            user.setMobile("");
            user.setStatus(0);
            user.setPassword(password);

            userService.save(ITBC.MEMBER_ROLE_ID,user);
        }

        return "redirect:/admin";
    }
}
