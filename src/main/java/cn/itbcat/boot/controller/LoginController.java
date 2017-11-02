package cn.itbcat.boot.controller;


import cn.itbcat.boot.api.OAuthServiceDeractor;
import cn.itbcat.boot.api.github.service.OAuthServices;
import cn.itbcat.boot.entity.admin.OAuthUser;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.repository.admin.OauthUserRepository;
import cn.itbcat.boot.repository.admin.UserRepository;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.utils.ITBC;
import cn.itbcat.boot.utils.SslUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/11.
 */
@Controller
public class LoginController extends ITBController{

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
        OAuthServiceDeractor oAuthService = oAuthServices.getOAuthService(type);
        SslUtils.ignoreSsl();
        Token accessToken = oAuthService.getAccessToken(null, new Verifier(code));
        OAuthUser oAuthInfo = oAuthService.getOAuthUser(accessToken);
        OAuthUser oAuthUser = oauthUserRepository.findByOAuthTypeAndOAuthId(oAuthInfo.getoAuthType(),
                oAuthInfo.getoAuthId());
        if(oAuthUser == null){
            model.addAttribute("oAuthInfo", oAuthInfo);
            return "/register-github";
        }
        String userId = oAuthUser.getUser().getUserId();
        User user = userService.get(userId);
        if(user == null){
            user.setUserId(oAuthUser.getUser().getUserId());
            oAuthInfo.setUser(user);
            model.addAttribute("oAuthInfo", oAuthInfo);
            return "/register-github";
        }
        if(null != user && StringUtils.isNotBlank(oAuthUser.getoAuthPas())){
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), oAuthUser.getoAuthPas());
            subject.login(token);
        }
        //request.getSession().setAttribute("oauthUser", oAuthUser);
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
    public String logout(Map<String,Object> dataModel) {
        Subject subject = SecurityUtils.getSubject();
        User user = ITBC.getCurrUser();
        subject.logout();
        dataModel.put("oAuthServices", oAuthServices.getAllOAuthServices());
        return "redirect:/login";
    }

    @RequestMapping(value = "/lock",method = RequestMethod.GET)
    public String lockMe(Map<String,Object> dataModel) {
        Subject subject = SecurityUtils.getSubject();
        User user = ITBC.getCurrUser();
        dataModel.put("oAuthServices", oAuthServices.getAllOAuthServices());
        if(null == user){
            return "redirect:/login";
        }
        dataModel.put("username",user.getEmail());
        subject.logout();
        return "lockme";
    }

    @RequestMapping(value = "/oauth/register",method = RequestMethod.POST)
    public String github(HttpServletRequest request,Map<String,Object> data) {

        String oauthId = request.getParameter("oauthId");
        String oauthType = request.getParameter("oauthType");
        String oauthUserName = request.getParameter("oauthUserName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        User u = userService.getUserByEmail(username);

        if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password) && StringUtils.isNotBlank(repassword)) {
            if (!password.equals(repassword)) {
                data.put("msg", "密码不一致");
                return "register-github";
            }
            User user = new User();

            if(null == u){
                user.setUserId(ITBC.getId());
                user.setEmail(username);
                user.setUsername(oauthUserName);
                user.setIsAdmin(ITBC.NOT_ADMIN);
                user.setDeptName("");
                user.setMobile("");
                user.setStatus(1);
                user.setPassword(password);
                user = userService.save2(ITBC.MEMBER_ROLE_ID,user);
            }else{
                u.setStatus(1);
                u.setUsername(oauthUserName);
                u.setPassword(password);
                user = userService.save2(ITBC.MEMBER_ROLE_ID,u);

            }

            OAuthUser authUser = new OAuthUser();
            authUser.setId(ITBC.getId());
            authUser.setUser(user);
            authUser.setoAuthId(oauthId);
            authUser.setoAuthType(oauthType);
            authUser.setoAuthPas(password);

            authUser = oauthUserRepository.save(authUser);

            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), authUser.getoAuthPas());
            subject.login(token);

        }
        return "redirect:/";
    }

}
