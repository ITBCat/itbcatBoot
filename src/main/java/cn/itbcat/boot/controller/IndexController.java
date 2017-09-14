package cn.itbcat.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by 860117030 on 2017/9/5.
 */
@Controller
@RequestMapping(value = "/admin")
public class IndexController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(Map<String, Object> dataModel){

        dataModel.put("template","index");
        return "index";
    }
    @RequestMapping(value = "/nopermissions")
    public String nopermissions(){
        return "nopermissions";
    }

}
