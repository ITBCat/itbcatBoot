package cn.itbcat.boot.service;

import cn.itbcat.boot.entity.Dept;
import cn.itbcat.boot.repository.DeptRepository;
import cn.itbcat.boot.utils.ITBC;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 860117030 on 2017/9/14.
 */
@Service
public class DeptService {


    @Autowired
    private DeptRepository deptRepository;

    public List<Dept> findDeptByParentId(String parentId) {
        if(StringUtils.isBlank(parentId)){
            parentId = "0";
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
}
