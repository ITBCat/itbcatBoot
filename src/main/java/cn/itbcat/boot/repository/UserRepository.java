package cn.itbcat.boot.repository;

import cn.itbcat.boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 860117030 on 2017/9/12.
 */
@Transactional
public interface UserRepository extends JpaRepository<User,String>,CrudRepository<User,String> {

    User findUserByEmail(String username);

    User findUserByToken(String token);
}
