package cn.itbcat.boot.service.admin;

import cn.itbcat.boot.entity.admin.Menu;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.repository.admin.MenuRepository;
import cn.itbcat.boot.utils.ITBC;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/7.
 */
@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Transactional(rollbackFor = Exception.class)
    public void save(Menu menu){

        menu.setMenuId(ITBC.getId());
        if("0".equals(menu.getParentId())){
            menu.setParentName("一级菜单");
        }else{
            Menu parent = menuRepository.findOne(menu.getParentId());
            menu.setParentName(parent.getName());
        }
        menu.setDelFlag("0");
        menuRepository.save(menu);
    }

    public Menu get(String id){
        Menu menu = null;
        try{
            menu = menuRepository.findOne(id);
            Menu parent = menuRepository.findOne(menu.getParentId());
            if(null == parent){
                menu.setParentName("一级菜单");
            }else {
                menu.setParentName(parent.getName());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return menu;
    }

    public List<Menu> findAllMenu() {
        //排序
        Sort sort = new Sort(Sort.Direction.DESC, "orderNum");
        List<Menu> list = menuRepository.findAll(sort);
        return list;
    }

    public List<Menu> findMenuByParentId(String parentId){

        if(StringUtils.isBlank(parentId)){
            parentId = "0";
        }
        List<Menu> list = menuRepository.findMenuByParentId(parentId);
        return list;
    }

    public void delete(String menuId) {
        menuRepository.delete(menuId);
    }

    public void update(Menu menu) {
        if("0".equals(menu.getParentId())){
            menu.setParentName("一级菜单");
        }else{
            Menu parent = menuRepository.findOne(menu.getParentId());
            menu.setParentName(parent.getName());
        }
        menu.setDelFlag("0");
        menuRepository.save(menu);
    }

    public List<Map<String,Object>> getMenuTree(User user) {

        Map<String,Object> parent = new HashMap<String,Object>();
        parent.put("id","0");
        parent.put("pId","-1");
        parent.put("name","一级菜单");

        List<Menu> list = menuRepository.findAll();

        List<Map<String,Object>> menuList = new ArrayList<Map<String, Object>>();
        for (Menu menu :list){
            Map<String,Object> m = new HashMap<String,Object>();
            m.put("id",menu.getMenuId());
            m.put("pId",menu.getParentId());
            m.put("name",menu.getName());
            menuList.add(m);
        }
        menuList.add(parent);

        return menuList;
    }
}
