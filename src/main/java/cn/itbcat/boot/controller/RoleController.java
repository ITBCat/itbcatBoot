package cn.itbcat.boot.controller;

import cn.itbcat.boot.entity.Role;
import cn.itbcat.boot.service.RoleService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/14.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 权限列表
     * @param template
     * @param request
     * @param response
     * @param dataModel 返回的数据
     * @return
     */
    @RequestMapping(value = "/{template}",method = RequestMethod.GET)
    @RequiresPermissions("admin:role:view")
    public String goToRole(@PathVariable String template, HttpServletRequest request, HttpServletResponse response, Map<String,Object> dataModel){
        dataModel.put("template",template);
        dataModel.put("roles",roleService.findAll());
        return "index";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @RequiresPermissions("admin:role:add")
    public String save(@ModelAttribute Role role,HttpServletRequest request){
        String menulist = request.getParameter("menuList");
        String deptlist = request.getParameter("deptList");
        roleService.save(role,menulist,deptlist);
        return "redirect:/role/role";
    }

    @RequestMapping(value = "/edit/{template}",method = RequestMethod.GET)
    @RequiresPermissions("admin:role:view")
    public String toEdit(@PathVariable String template,HttpServletRequest request,Map<String,Object> dataModel){
        String roleId = request.getParameter("roleId");
        dataModel.put("template",template);
        if(StringUtils.isNotBlank(roleId)){
            dataModel.put("role",roleService.get(roleId));
            dataModel.put("menuIds",roleService.getMenuList(roleId).toString());
            dataModel.put("deptList",roleService.getDeptList(roleId));
        }
        return "index";
    }

}
