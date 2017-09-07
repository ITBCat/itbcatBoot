package cn.itbcat.boot.service;

import cn.itbcat.boot.entity.Menu;
import cn.itbcat.boot.repository.MenuRepository;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by 860117030 on 2017/9/7.
 */
@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Transactional(rollbackFor = Exception.class)
    public void save(Menu menu){
        String pid = menu.getParentId();
        Menu parent = null;
        if (!StringUtils.isEmpty(pid)){
            parent = this.get(pid);
            if(null != parent){
                menu.setParentName(parent.getName());
            }
        }else{
            menu.setParentName("顶级菜单");
            menu.setParentId("0");
        }
        //ID
        menu.setId(ITBC.getId());
        //删除标记
        menu.setDelFlag(ITBC.DEL_FLAG_NORMAL);
        menuRepository.save(menu);
    }

    public Menu get(String id){
        Menu menu = null;
        try{
            menu = menuRepository.findOne(id);
        }catch (Exception e){
            e.printStackTrace();
        }

        return menu;
    }
}
