package cn.itbcat.boot.repository;

import cn.itbcat.boot.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 860117030 on 2017/9/6.
 */
public interface MenuRepository extends JpaRepository<Menu,String> {



}
