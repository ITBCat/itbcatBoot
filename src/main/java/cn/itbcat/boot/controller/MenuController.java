package cn.itbcat.boot.controller;

import cn.itbcat.boot.config.webConfig;
import cn.itbcat.boot.entity.Menu;
import cn.itbcat.boot.entity.User;
import cn.itbcat.boot.service.MenuService;
import cn.itbcat.boot.utils.ITBC;
import freemarker.template.utility.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/6.
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 菜单列表
     * @param template
     * @param request
     * @param response
     * @param dataModel 返回的数据
     * @return
     */
    @RequestMapping(value = "/{template}",method = RequestMethod.GET)
    public String goToMenu(@PathVariable String template, HttpServletRequest request, HttpServletResponse response, Map<String,Object> dataModel){
        dataModel.put("template",template);
        String parentId = request.getParameter("parentId");
        dataModel.put("menus",getMenuList(parentId));
        if(StringUtils.isBlank(parentId)){
            dataModel.put("parentName","一级菜单");
        }else{
            dataModel.put("parentName",menuService.get(parentId).getName());
        }
        return "index";
    }

    private List<Menu> getMenuList(String parentId){

        List<Menu> list = menuService.findMenuByParentId(parentId);

        return list;
    }

    /**
     * 保存菜单
     * @param menu
     * @param dataModel
     * @return
     */
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
        return "redirect:/menu/menu";
    }

    /**
     * 删除菜单
     * @param menuId
     * @param dataModel
     * @return
     */
    @RequestMapping(value = "/delete/{menuId}",method = RequestMethod.GET)
    @RequiresPermissions("admin:menu:delete")
    public String delete(@PathVariable String menuId,Map<String,Object> dataModel){

        menuService.delete(menuId);

        return "redirect:/menu/menu";
    }

    /**
     * 修改菜单
     * @param template
     * @param dataModel
     * @param request
     * @return
     */
    @RequestMapping(value = "/edit/{template}",method = RequestMethod.GET)
    @RequiresPermissions("admin:menu:edit")
    public String toEdit(@PathVariable String template,Map<String,Object> dataModel,HttpServletRequest request){
        String menuId = request.getParameter("menuId");
        dataModel.put("template",template);
        dataModel.put("menus",getMenuList(null));
        dataModel.put("menu",menuService.get(menuId));
        return "index";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @RequiresPermissions("admin:menu:edit")
    public String edit(@ModelAttribute Menu menu){

        menuService.update(menu);

        return "redirect:/menu/menu";
    }

    @ResponseBody
    @RequestMapping(value = "/tree",method = RequestMethod.POST)
    public List<Map<String,Object>> menuTree(){

        User user = ITBC.getCurrUser();

        return menuService.getMenuTree(user);
    }

}
