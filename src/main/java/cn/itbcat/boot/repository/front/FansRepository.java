package cn.itbcat.boot.repository.front;

import cn.itbcat.boot.entity.front.Fans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Seven on 2017/11/7.
 */
@Repository
@Transactional
public interface FansRepository extends JpaRepository<Fans,String> {
}
