package cn.itbcat.boot.controller;


import cn.itbcat.boot.api.github.service.CustomOAuthService;
import cn.itbcat.boot.api.github.service.OAuthServiceDeractor;
import cn.itbcat.boot.api.github.service.OAuthServices;
import cn.itbcat.boot.entity.admin.OAuthUser;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.common.Result;
import cn.itbcat.boot.repository.admin.OauthUserRepository;
import cn.itbcat.boot.repository.admin.UserRepository;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.utils.ITBC;
import cn.itbcat.boot.utils.SslUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/11.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    OAuthServices oAuthServices;
    @Autowired
    OauthUserRepository oauthUserRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    public String login(Map<String,Object> data){
        data.put("oAuthServices", oAuthServices.getAllOAuthServices());
        return "login";
    }

    @RequestMapping(value = {"/info-steps"},method = RequestMethod.GET)
    public String info(Map<String,Object> data){
        return "/module/front/info-steps";
    }

    @RequestMapping(value = "/oauth/{type}/callback", method=RequestMethod.GET)
    public String claaback(@RequestParam(value = "code", required = true) String code,
                           @PathVariable(value = "type") String type,
                           HttpServletRequest request, Model model) throws Exception {
        CustomOAuthService oAuthService = oAuthServices.getOAuthService(type);
        SslUtils.ignoreSsl();
        Token accessToken = oAuthService.getAccessToken(null, new Verifier(code));
        OAuthUser oAuthInfo = oAuthService.getOAuthUser(accessToken);
        OAuthUser oAuthUser = oauthUserRepository.findByOAuthTypeAndOAuthId(oAuthInfo.getoAuthType(),
                oAuthInfo.getoAuthId());
        if(oAuthUser == null){
            model.addAttribute("oAuthInfo", oAuthInfo);
            return "/module/front/info-steps";
        }
        request.getSession().setAttribute("oauthUser", oAuthUser);
        return "redirect:/";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String toLogin(String username, String password, Map<String,Object> dataModel){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
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

    @RequestMapping(value = "/oauth/mail",method = RequestMethod.POST)
    @ResponseBody
    public Result oauthemail(HttpServletRequest request){
        String id = request.getParameter("id");
        String mail = request.getParameter("mail");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        try {
            User user = new User();
            user.setUserId(ITBC.getId());
            user.setUsername(name);
            user.setCreateTime(new Date());
            user.setIsAdmin(ITBC.NOT_ADMIN);
            user.setDeptName("");
            user.setMobile("");
            user.setDeptId("");
            user.setStatus(1);
            userService.save(ITBC.MEMBER_ROLE_ID,user);
            OAuthUser oAuthUser = new OAuthUser();
            oAuthUser.setId(ITBC.getId());
            oAuthUser.setoAuthId(id);
            oAuthUser.setoAuthType(type);
            oAuthUser.setUser(user);
            oauthUserRepository.save(oAuthUser);
            return new Result(ITBC.SUCCESS_CODE,user.getUserId(),"");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result(ITBC.ERROR_CODE,null,"");
    }
}
