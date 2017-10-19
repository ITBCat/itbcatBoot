package cn.itbcat.boot.service.admin;

import cn.itbcat.boot.entity.admin.Dept;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.repository.admin.DeptRepository;
import cn.itbcat.boot.utils.ITBC;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 860117030 on 2017/9/14.
 */
@Service
public class DeptService {


    @Autowired
    private DeptRepository deptRepository;

    public List<Dept> findDeptByParentId(String parentId) {
        if(StringUtils.isBlank(parentId)){
            parentId = "1";
        }
        return deptRepository.findByParentId(parentId);
    }

    public void save(Dept dept) {
        dept.setDeptId(ITBC.getId());
        if("0".equals(dept.getParentId())){
            dept.setParentName("一级部门");
        }
        deptRepository.save(dept);
    }

    public Dept get(String Id) {
        return deptRepository.findOne(Id);
    }

    public List<Map<String,Object>> tree(User user) {

        List<Dept> list = null;
        //管理员显示全部部门
        if(user.getUserId().equals(ITBC.SUPER_ADMIN)){
            list = deptRepository.findAll();
            Dept dept = new Dept();
            dept.setDeptId("1");
            dept.setName("一级部门");
            dept.setParentId("0");
            list.add(dept);
        }else{
            //不是Admin显示所在部门以及子部门
            Dept parent = deptRepository.findOne("1505377991704");
            list = deptRepository.findByParentId(parent.getDeptId());
            list.add(parent);
        }

        //组装树
        List<Map<String,Object>> depts = new ArrayList<Map<String, Object>>();
        for (Dept dept : list){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("id",dept.getDeptId());
            map.put("pId",dept.getParentId());
            map.put("name",dept.getName());
            depts.add(map);
        }

        return depts;
    }

    public void delete(String deptId) {
        try {
        List<Dept> list = findDeptByParentId(deptId);

        //删除父级节点下的所有子节点
        for(Dept dept : list){
            deptRepository.delete(dept);
        }

        //删除父节点
        deptRepository.delete(deptId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
