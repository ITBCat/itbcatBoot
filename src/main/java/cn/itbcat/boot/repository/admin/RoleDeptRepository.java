package cn.itbcat.boot.repository.admin;

import cn.itbcat.boot.entity.admin.RoleDept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by BrickCat on 17/9/17.
 */
@Repository
@Transactional
public interface RoleDeptRepository extends JpaRepository<RoleDept,String>,CrudRepository<RoleDept,String> {
    List<RoleDept> findByRoleId(String roleId);

    @Modifying
    @Query(value = "delete from sys_role_dept where role_id=?1", nativeQuery = true)
    void deleteByRoleId(String roleId);
}
