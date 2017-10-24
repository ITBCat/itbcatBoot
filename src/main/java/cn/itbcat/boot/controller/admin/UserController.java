package cn.itbcat.boot.controller.admin;

import cn.itbcat.boot.entity.admin.Role;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.utils.ITBC;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/12.
 */
@Controller
@RequestMapping(ITBC.SERVER_NAME_ADMIN+"/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequiresPermissions("admin:user:view")
    @RequestMapping(value = "/{template}",method = RequestMethod.GET)
    public String toUser(@PathVariable String template, Map<String,Object> dataModel){
        dataModel.put("template",template);

        dataModel.put("users",userService.findAll());

        dataModel.put("roles",getAllRole());

        return ITBC.SYSTEM_ADMIN_TEMPLATE;
    }

    public List<Role> getAllRole(){
        return userService.getAllRole();
    }

    @RequiresPermissions("admin:user:add")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String add(@ModelAttribute User user, HttpServletRequest request){
        String roleId = request.getParameter("roleId");
        if(ITBC.ROLE_ADMIN.equals(roleId)){
            user.setIsAdmin(ITBC.NOT_ADMIN);
        }else {
            user.setIsAdmin(ITBC.IS_ADMIN);
        }
        userService.save(roleId,user);
        return "redirect:"+ITBC.SERVER_NAME_ADMIN+"/user/user";
    }

    @RequiresPermissions("admin:user:edit")
    @RequestMapping(value = "/edit/{template}",method = RequestMethod.GET)
    public String toEdit(@PathVariable String template,HttpServletRequest request,Map<String,Object> dataModel){

        String userId = request.getParameter("userId");
        if(StringUtils.isNotBlank(userId)){
            dataModel.put("user",userService.get(userId));
        }
        dataModel.put("roleId",userService.getRoleId(userId));
        dataModel.put("roles",getAllRole());
        dataModel.put("template",template);

        return ITBC.SYSTEM_ADMIN_TEMPLATE;
    }

    @RequiresPermissions("admin:user:edit")
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(@ModelAttribute User user,HttpServletRequest request){

        String roleId = request.getParameter("roleId");

        try {
            if(ITBC.ROLE_ADMIN.equals(roleId)){
                user.setIsAdmin(ITBC.NOT_ADMIN);
            }else {
                user.setIsAdmin(ITBC.IS_ADMIN);
            }
            userService.update(roleId,user);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:"+ITBC.SERVER_NAME_ADMIN+"/user/user";
    }

    @RequiresPermissions("admin:user:delete")
    @RequestMapping(value = "/delete/{userId}",method = RequestMethod.GET)
    public String delete(@PathVariable String userId){
        try {
            userService.delete(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:"+ITBC.SERVER_NAME_ADMIN+"/user/user";
    }

}
