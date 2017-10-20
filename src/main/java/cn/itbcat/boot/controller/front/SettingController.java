package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.entity.common.Result;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by BrickCat on 17/10/20.
 */
@Controller
@RequestMapping(ITBC.SERVER_NAME_FRONT)
public class SettingController {

    @RequestMapping(value = "/settings",method = RequestMethod.GET)
    public String setting(Map<String,Object> data){
        data.put(ITBC.TEMPLATE,"settings");
        return ITBC.SYSTEM_FRONT_TEMPLATE;
    }

    @RequestMapping(value = "/settings/avatar",method = RequestMethod.POST)
    @ResponseBody
    public Result upload(@RequestParam(value = "avatar") MultipartFile file){

        return null;
    }
}
