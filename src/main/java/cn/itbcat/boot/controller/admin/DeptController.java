package cn.itbcat.boot.controller.admin;

import cn.itbcat.boot.entity.admin.Dept;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.service.admin.DeptService;
import cn.itbcat.boot.utils.ITBC;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/14.
 */
@Controller
@RequestMapping(ITBC.SERVER_NAME_ADMIN+"/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;
    /**
     * 权限列表
     * @param template
     * @param request
     * @param response
     * @param dataModel 返回的数据
     * @return
     */
    @RequestMapping(value = "/{template}",method = RequestMethod.GET)
    @RequiresPermissions("admin:dept:view")
    public String goToDept(@PathVariable String template, HttpServletRequest request, HttpServletResponse response, Map<String,Object> dataModel){
        dataModel.put("template",template);
        String parentId = request.getParameter("parentId");
        dataModel.put("depts",deptService.findDeptByParentId(parentId));
        if(StringUtils.isBlank(parentId)){
            dataModel.put("parentName","一级部门");
        }else{
            dataModel.put("parentName",deptService.get(parentId).getName());
        }
        return "index";
    }

    /**
     * 保存Dept
     * @param dept
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @RequiresPermissions("admin:dept:add")
    public String save(@ModelAttribute Dept dept){
        try {
            deptService.save(dept);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:"+ITBC.SERVER_NAME_ADMIN+"/dept/dept";
    }

    /**
     * 部门树
     * @return
     */
    @RequestMapping(value = "/tree",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> tree(){
        User user = ITBC.getCurrUser();
        List<Map<String,Object>> list = deptService.tree(user);
        return list;
    }

    /**
     * 删除部门
     */
    @RequestMapping(value = "/detele/{deptId}",method = RequestMethod.GET)
    @RequiresPermissions("admin:dept:delete")
    public String delete(@PathVariable String deptId){
        try{
            deptService.delete(deptId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:"+ITBC.SERVER_NAME_ADMIN+"/dept/dept";
    }

    @RequestMapping(value = "/edit/{template}",method = RequestMethod.GET)
    @RequiresPermissions("admin:dept:edit")
    public String toEdit(@PathVariable String template, HttpServletRequest request,Map<String,Object> dataModel){
        dataModel.put("dept",deptService.get(request.getParameter("deptId")));
        dataModel.put("template",template);
        return "index";
    }
}
