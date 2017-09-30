package cn.itbcat.boot.service;

import cn.itbcat.boot.entity.Menu;
import cn.itbcat.boot.entity.User;
import cn.itbcat.boot.repository.MenuRepository;
import cn.itbcat.boot.repository.UserRepository;
import cn.itbcat.boot.repository.UserRoleRepository;
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
