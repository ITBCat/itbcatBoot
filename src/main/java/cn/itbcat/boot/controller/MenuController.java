package cn.itbcat.boot.controller;

import cn.itbcat.boot.entity.Menu;
import cn.itbcat.boot.service.MenuService;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/6.
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/{template}",method = RequestMethod.GET)
    public String goToMenu(@PathVariable String template, HttpServletRequest request, HttpServletResponse response, Map<String,Object> dataModel){
        dataModel.put("template",template);
        return "index";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@ModelAttribute Menu menu,Map<String,Object> dataModel){
        dataModel.put("template","menu");
        if(null == menu){
            dataModel.put("msg","保存菜单出错啦~");
        }
        try {
            menuService.save(menu);
        }catch (Exception e){
            dataModel.put("msg",e.toString());
            e.printStackTrace();
        }
        return "index";
    }

}
