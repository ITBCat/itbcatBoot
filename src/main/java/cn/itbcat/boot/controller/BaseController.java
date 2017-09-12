package cn.itbcat.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by 860117030 on 2017/9/6.
 */
@Controller
public class BaseController {
    @RequestMapping(value = "/{template}",method = RequestMethod.GET)
    public String index(@PathVariable String template, Map<String,Object> dataModel){
        dataModel.put("template",template);
        return "index";
    }
}
