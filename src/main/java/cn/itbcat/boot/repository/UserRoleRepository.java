package cn.itbcat.boot.repository;

import cn.itbcat.boot.entity.Role;
import cn.itbcat.boot.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 860117030 on 2017/9/12.
 */
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole,String> {

//    @Query("select m.perms from sys_user_role ur LEFT JOIN sys_role_menu rm on ur.role_id = rm.role_id LEFT JOIN sys_menu m on rm.menu_id = m.menu_id where ur.user_id = ?1")
//    List<String> queryAllPerms(String userId);
}
