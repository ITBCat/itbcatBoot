package cn.itbcat.boot.controller.admin;

import cn.itbcat.boot.controller.ITBController;
import cn.itbcat.boot.entity.admin.Role;
import cn.itbcat.boot.service.admin.RoleService;
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
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/14.
 */
@Controller
@RequestMapping(ITBC.SERVER_NAME_ADMIN+"/role")
public class RoleController extends ITBController{

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
        dataModel.putAll(dataModel());
        dataModel.put("template",template);
        dataModel.put("roles",roleService.findAll());
        return ITBC.SYSTEM_ADMIN_TEMPLATE;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @RequiresPermissions("admin:role:add")
    public String save(@ModelAttribute Role role,HttpServletRequest request){
        String menulist = request.getParameter("menuList");
        String deptlist = request.getParameter("deptList");
        roleService.save(role,menulist,deptlist);
        return "redirect:"+ITBC.SERVER_NAME_ADMIN+"/role/role";
    }

    @RequestMapping(value = "/edit/{template}",method = RequestMethod.GET)
    @RequiresPermissions("admin:role:view")
    public String toEdit(@PathVariable String template,HttpServletRequest request,Map<String,Object> dataModel){
        dataModel.putAll(dataModel());
        String roleId = request.getParameter("roleId");
        dataModel.put("template",template);
        if(StringUtils.isNotBlank(roleId)){
            dataModel.put("role",roleService.get(roleId));
            dataModel.put("menuIds",roleService.getMenuList(roleId).toString());
            dataModel.put("deptIds",roleService.getDeptList(roleId).toString());
        }
        return ITBC.SYSTEM_ADMIN_TEMPLATE;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @RequiresPermissions("admin:role:edit")
    public String edit(@ModelAttribute Role role,HttpServletRequest request){

        if (null != role && StringUtils.isNotBlank(role.getRoleId())){
            String menuIds = request.getParameter("menuList");
            if(StringUtils.isNotBlank(menuIds)){
                roleService.updateMenuIds(role.getRoleId(),menuIds);
            }
            String deptIds = request.getParameter("deptList");
            if(StringUtils.isNotBlank(deptIds)){
                roleService.updateDeptIds(role.getRoleId(),deptIds);
            }
        }

        roleService.update(role);

        return "redirect:"+ITBC.SERVER_NAME_ADMIN+"/role/role";
    }

    @RequiresPermissions("admin:role:delete")
    @RequestMapping(value = "/delete/{roleId}",method = RequestMethod.GET)
    public String delete(@PathVariable String roleId){
        roleService.delete(roleId);
        return "redirect:"+ITBC.SERVER_NAME_ADMIN+"/role/role";
    }

}
