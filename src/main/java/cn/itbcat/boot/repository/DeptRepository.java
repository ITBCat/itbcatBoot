package cn.itbcat.boot.repository;

import cn.itbcat.boot.entity.Dept;
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
