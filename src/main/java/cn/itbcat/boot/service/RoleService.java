package cn.itbcat.boot.service;

import cn.itbcat.boot.entity.Role;
import cn.itbcat.boot.entity.RoleDept;
import cn.itbcat.boot.entity.RoleMenu;
import cn.itbcat.boot.repository.RoleDeptRepository;
import cn.itbcat.boot.repository.RoleMenuRepository;
import cn.itbcat.boot.repository.RoleRepositor;
import cn.itbcat.boot.utils.ITBC;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by BrickCat on 17/9/16.
 */

@Service
public class RoleService {

    @Autowired
    private RoleRepositor roleRepositor;
    @Autowired
    private RoleMenuRepository roleMenuRepository;
    @Autowired
    private RoleDeptRepository roleDeptRepository;


    public List<Role> findAll() {
        List<Role> list = roleRepositor.findAll();

        return roleRepositor.findAll();
    }

    public void save(Role role,String menuList,String deptList) {
        String roleId = ITBC.getId();
        role.setRoleId(roleId);
        role.setCreateTime(new Date());
        try{
            //保存菜单角色
            if(StringUtils.isNotBlank(menuList)){
                String[] menuIds = menuList.split(",");
                for(String id : menuIds){
                    if(!"0".equals(id)){
                        RoleMenu roleMenu = new RoleMenu();
                        roleMenu.setId(ITBC.getId());
                        roleMenu.setMenuId(id);
                        roleMenu.setRoleId(roleId);
                        roleMenuRepository.save(roleMenu);
                    }
                }
            }
            //保存部门角色
            if(StringUtils.isNotBlank(deptList)){
                String[] deptIds = deptList.split(",");
                for (String id : deptIds){
                    if(!"1".equals(id)){
                        RoleDept dept = new RoleDept();
                        dept.setId(ITBC.getId());
                        dept.setDeptId(id);
                        dept.setRoleId(roleId);
                        roleDeptRepository.save(dept);
                    }
                }
            }
            roleRepositor.save(role);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Object get(String roleId) {
        return roleRepositor.findOne(roleId);
    }

    public JSONArray getMenuList(String roleId) {

        List<RoleMenu> list = roleMenuRepository.findByRoleId(roleId);

        JSONArray menuIds = new JSONArray();
        for (RoleMenu roleMenu : list){
            JSONObject rm = new JSONObject();
            rm.put("id",roleMenu.getMenuId());
            menuIds.add(rm);
        }

        return menuIds;
    }

    public JSONArray getDeptList(String roleId) {

        List<RoleDept> list = roleDeptRepository.findByRoleId(roleId);
        JSONArray deptIds = new JSONArray();

        for(RoleDept roleDept : list){
            JSONObject rd = new JSONObject();
            rd.put("id",roleDept.getDeptId());
            deptIds.add(rd);
        }

        return deptIds;
    }
}
