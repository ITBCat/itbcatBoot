package cn.itbcat.boot.service;

import cn.itbcat.boot.entity.Role;
import cn.itbcat.boot.repository.RoleRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by BrickCat on 17/9/16.
 */

@Service
public class RoleService {

    @Autowired
    private RoleRepositor roleRepositor;

    public List<Role> findAll() {
        List<Role> list = roleRepositor.findAll();

        return roleRepositor.findAll();
    }
}
