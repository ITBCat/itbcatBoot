package cn.itbcat.boot.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
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

    /**
     * 权限列表
     * @param template
     * @param request
     * @param response
     * @param dataModel 返回的数据
     * @return
     */
    @RequestMapping(value = "/{template}",method = RequestMethod.GET)
    public String goToRole(@PathVariable String template, HttpServletRequest request, HttpServletResponse response, Map<String,Object> dataModel){
        dataModel.put("template",template);
        return "index";
    }

}
