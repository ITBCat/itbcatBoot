package cn.itbcat.boot.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by 860117030 on 2017/9/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @RequiresPermissions("admin:user:view")
    @RequestMapping(value = "/{template}",method = RequestMethod.GET)
    public String toUser(@PathVariable String template, Map<String,Object> dataModel){
        dataModel.put("template",template);
        return "index";
    }

    

}
