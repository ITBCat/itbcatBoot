package cn.itbcat.boot.controller.admin;

import cn.itbcat.boot.controller.ITBController;
import cn.itbcat.boot.utils.ITBC;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by 860117030 on 2017/9/30.
 */
@Controller
@RequestMapping(ITBC.SERVER_NAME_ADMIN)
public class HealthController extends ITBController {

    @RequestMapping(value = "/healths",method = RequestMethod.GET)
    @RequiresPermissions("admin:health:view")
    public String index(Map<String, Object> dataModel){
        dataModel.putAll(dataModel());
        dataModel.put("template","health");
        return ITBC.SYSTEM_ADMIN_TEMPLATE;
    }
}
