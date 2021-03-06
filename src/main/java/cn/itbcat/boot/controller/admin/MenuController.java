package cn.itbcat.boot.controller.admin;

import cn.itbcat.boot.controller.ITBController;
import cn.itbcat.boot.entity.admin.Menu;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.service.admin.MenuService;
import cn.itbcat.boot.utils.ITBC;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/6.
 */
@Controller
@RequestMapping(value = ITBC.SERVER_NAME_ADMIN+"/menu")
public class MenuController extends ITBController{

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
    @RequiresPermissions("admin:menu:view")
    @RequestMapping(value = "/{template}",method = RequestMethod.GET)
    public String goToMenu(@PathVariable String template, HttpServletRequest request, HttpServletResponse response, Map<String,Object> dataModel){
        dataModel.putAll(dataModel());
        dataModel.put("template",template);
        String parentId = request.getParameter("parentId");
        dataModel.put("menus",getMenuList(parentId));
        if(StringUtils.isBlank(parentId)){
            dataModel.put("parentName","一级菜单");
        }else{
            dataModel.put("parentName",menuService.get(parentId).getName());
        }
        return ITBC.SYSTEM_ADMIN_TEMPLATE;
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
    @RequiresPermissions("admin:menu:add")
    public String save(@ModelAttribute Menu menu,Map<String,Object> dataModel){
        dataModel.putAll(dataModel());
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
        return "redirect:"+ITBC.SERVER_NAME_ADMIN+"/menu/menu";
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

        return "redirect:"+ITBC.SERVER_NAME_ADMIN+"/menu/menu";
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
        dataModel.putAll(dataModel());
        String menuId = request.getParameter("menuId");
        dataModel.put("template",template);
        dataModel.put("menus",getMenuList(null));
        dataModel.put("menu",menuService.get(menuId));
        return ITBC.SYSTEM_ADMIN_TEMPLATE;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @RequiresPermissions("admin:menu:edit")
    public String edit(@ModelAttribute Menu menu){

        menuService.update(menu);

        return "redirect:"+ITBC.SERVER_NAME_ADMIN+"/menu/menu";
    }

    @ResponseBody
    @RequestMapping(value = "/tree",method = RequestMethod.POST)
    public List<Map<String,Object>> menuTree(){

        User user = ITBC.getCurrUser();

        return menuService.getMenuTree(user);
    }

}
