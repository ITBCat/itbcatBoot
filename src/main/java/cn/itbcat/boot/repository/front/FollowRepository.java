package cn.itbcat.boot.repository.front;

import cn.itbcat.boot.entity.front.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by 860117030 on 2017/11/7.
 */
@Repository
@Transactional
public interface FollowRepository extends JpaRepository<Follow,String> {

}
