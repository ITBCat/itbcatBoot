package cn.itbcat.boot.repository.admin;

import cn.itbcat.boot.entity.admin.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by BrickCat on 17/9/17.
 */
@Transactional
public interface RoleMenuRepository extends JpaRepository<RoleMenu,String>,CrudRepository<RoleMenu,String> {
    List<RoleMenu> findByRoleId(String roleId);

    @Modifying
    @Query(value = "delete from sys_role_menu where role_id=?1", nativeQuery = true)
    void deleteByRoleId(String roleId);
}
