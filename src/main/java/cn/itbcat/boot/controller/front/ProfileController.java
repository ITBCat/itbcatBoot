package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.controller.ITBController;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by 860117030 on 2017/11/6.
 */
@Controller
@RequestMapping(ITBC.SERVER_NAME_FRONT)
public class ProfileController extends ITBController {



    @RequestMapping(value = "/profile/{userId}",method = RequestMethod.GET)
    public String profile(@PathVariable String userId, Map<String,Object> data){
        User user = userService.get(userId);
        data.put(ITBC.PROFILER,user);
        data.putAll(dataModel());
        data.put(ITBC.TEMPLATE,"profile");
        return "front";
    }
}
