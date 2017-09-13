package cn.itbcat.boot.service;

import cn.itbcat.boot.entity.Menu;
import cn.itbcat.boot.repository.MenuRepository;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * Created by 860117030 on 2017/9/7.
 */
@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Transactional(rollbackFor = Exception.class)
    public void save(Menu menu){
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

    public List<Menu> findAllMenu() {
        //排序
        Sort sort = new Sort(Sort.Direction.DESC, "sort");
        List<Menu> list = menuRepository.findAll(sort);
        return list;
    }
}
