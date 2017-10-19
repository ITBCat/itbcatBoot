package cn.itbcat.boot.controller;

import cn.itbcat.boot.entity.admin.Email;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.service.admin.IMailService;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.utils.ITBC;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/12.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private IMailService mailService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String toRegister(HttpServletRequest request, Map<String,Object> data){

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        User u = userService.getUserByEmail(username);
        if(null != u){
            data.put("msg","该用户已存在");
            return "register";
        }

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
            user.setStatus(2);
            user.setPassword(password);

            try{
                String token = userService.save(ITBC.MEMBER_ROLE_ID,user);

                if(StringUtils.isNotBlank(token)){
                    Email mail = new Email();
                    mail.setEmail(new String[]{username});
                    mail.setSubject("ITBC-注册验证邮件");
                    mail.setContent(token);
                    mail.setTemplate("mail");
                    mailService.sendFreemarker(mail);
                }

            }catch (Exception e){
                e.printStackTrace();
            }



        }

        return "redirect:"+ITBC.SERVER_NAME_ADMIN+"/admin";
    }

    @RequestMapping(value = "/mail",method = RequestMethod.GET)
    public String mail(){
        return "mail";
    }

    @RequestMapping(value = "/mail/{token}",method = RequestMethod.GET)
    public String valmail(@PathVariable String token){
        User user = userService.getUserByToken(token);
        if (null != user)
            user.setStatus(1);
        userService.save(user.getUserId(),user);
        System.out.print(token);
        return "login";
    }
}
