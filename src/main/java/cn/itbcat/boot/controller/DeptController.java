package cn.itbcat.boot.controller;

import cn.itbcat.boot.entity.Dept;
import cn.itbcat.boot.entity.User;
import cn.itbcat.boot.service.DeptService;
import cn.itbcat.boot.utils.ITBC;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/14.
 */
@Controller
@RequestMapping("/dept")
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

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@ModelAttribute Dept dept){
        try {
            deptService.save(dept);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/dept/dept";
    }

    @RequestMapping(value = "/tree",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> tree(){
        User user = ITBC.getCurrUser();
        List<Map<String,Object>> list = deptService.tree(user);
        return list;
    }

}
