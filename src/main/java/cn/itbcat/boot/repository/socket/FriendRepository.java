package cn.itbcat.boot.repository.socket;

import cn.itbcat.boot.entity.socket.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 860117030 on 2017/10/27.
 */
@Repository
@Transactional
public interface FriendRepository extends JpaRepository<Friend,String>,CrudRepository<Friend,String> {

    List<Friend> findFriendByUserId(String userId);
}
