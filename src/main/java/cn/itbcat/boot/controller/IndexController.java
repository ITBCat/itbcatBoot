package cn.itbcat.boot.controller;

import cn.itbcat.boot.config.propsConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by 860117030 on 2017/9/5.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Map<String,Object> map){

        map.put("title","ITBCAT");
        map.put("template","index");
        return "index";
    }

}
