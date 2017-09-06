package cn.itbcat.boot.controller;

import freemarker.template.utility.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/6.
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @RequestMapping(value = "/{template}",method = RequestMethod.GET)
    public String addMenu(@PathVariable String template, HttpServletRequest request, HttpServletResponse response, Map<String,Object> map){

        map.put("template",template);
        map.put("title","菜单管理|ITBC系统");
        return "index";
    }

}
