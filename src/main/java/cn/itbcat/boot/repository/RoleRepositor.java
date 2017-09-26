package cn.itbcat.boot.repository;

import cn.itbcat.boot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by BrickCat on 17/9/16.
 */
@Transactional
public interface RoleRepositor extends JpaRepository<Role,String>,CrudRepository<Role,String> {
}
