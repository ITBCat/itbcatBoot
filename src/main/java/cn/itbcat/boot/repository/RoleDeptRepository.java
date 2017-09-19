package cn.itbcat.boot.repository;

import cn.itbcat.boot.entity.RoleDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by BrickCat on 17/9/17.
 */
@Transactional
public interface RoleDeptRepository extends JpaRepository<RoleDept,String>,CrudRepository<RoleDept,String> {
    List<RoleDept> findByRoleId(String roleId);
}
