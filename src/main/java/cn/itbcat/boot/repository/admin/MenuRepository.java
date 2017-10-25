package cn.itbcat.boot.repository.admin;

import cn.itbcat.boot.entity.admin.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 860117030 on 2017/9/6.
 */
@Repository
@Transactional
public interface MenuRepository extends JpaRepository<Menu,String> ,CrudRepository<Menu,String> {

    @Query(value = "select m.perms from sys_user_role ur LEFT JOIN sys_role_menu rm on ur.role_id = rm.role_id" +
            " LEFT JOIN sys_menu m on rm.menu_id = m.menu_id where ur.user_id = ?1",nativeQuery = true)
    List<String> queryAllPerms(String userId);

    List<Menu> findMenuByParentId(String parentId);
}
