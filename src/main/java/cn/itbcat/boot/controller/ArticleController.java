package cn.itbcat.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by 860117030 on 2017/10/12.
 */
@Controller
@RequestMapping(value = "/f")
public class ArticleController {

    @RequestMapping(value = "/put",method = RequestMethod.GET)
    public String toPut(Map<String,Object> data){

        data.put("template","put");
        return "module/front/put";
    }
}
