package cn.itbcat.boot.repository;

import cn.itbcat.boot.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 860117030 on 2017/9/6.
 */
@Transactional
public interface MenuRepository extends JpaRepository<Menu,String> ,CrudRepository<Menu,String> {



}
