package cn.itbcat.boot.repository.admin;

import cn.itbcat.boot.entity.admin.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 860117030 on 2017/9/14.
 */
@Transactional
public interface DeptRepository extends JpaRepository<Dept, String> {

    List<Dept> findByParentId(String parentId);

}
