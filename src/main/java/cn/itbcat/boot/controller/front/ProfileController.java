package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.controller.ITBController;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by 860117030 on 2017/11/6.
 */
@Controller
@RequestMapping(ITBC.SERVER_NAME_FRONT)
public class ProfileController extends ITBController {

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public String profile(Map<String,Object> data){
        data.putAll(dataModel());
        return "";
    }
}
