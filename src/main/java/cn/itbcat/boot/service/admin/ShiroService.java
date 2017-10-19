package cn.itbcat.boot.service.admin;

import cn.itbcat.boot.entity.admin.Menu;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.repository.admin.MenuRepository;
import cn.itbcat.boot.repository.admin.UserRepository;
import cn.itbcat.boot.utils.ITBC;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by 860117030 on 2017/9/13.
 */
@Service
public class ShiroService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private UserRepository userRepository;


    public Set<String> getUserPermissions(String userId) {
        List<String> permsList;
        User u =userRepository.findOne(userId);
        //系统管理员，拥有最高权限
        if(u.getIsAdmin().equals(ITBC.SUPER_ADMIN)){
            List<Menu> menuList = menuRepository.findAll();
            permsList = new ArrayList<>(menuList.size());
            for(Menu menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            //不是超级管理员
            permsList = menuRepository.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }
}
