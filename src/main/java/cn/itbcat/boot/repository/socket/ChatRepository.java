package cn.itbcat.boot.repository.socket;

import cn.itbcat.boot.entity.socket.Chat;
import cn.itbcat.boot.entity.socket.MessageType;
import cn.itbcat.boot.entity.socket.SendType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 860117030 on 2017/10/25.
 */
@Repository
@Transactional
public interface ChatRepository extends JpaRepository<Chat,String>,JpaSpecificationExecutor<Chat> {

    @Query("select ic from Chat ic where receiveId=:receiveId and sendType=:sendType and type=:type ")
    List<Chat> getListByParam(@Param("receiveId")String receiveId, @Param("sendType")SendType sendType, @Param("type") MessageType type);

    List<Chat> findChatByReceiveIdAndUserId(String receiveId, String currUserId);

    List<Chat> findChatByReceiveId(String receiveId);

    List<Chat> findChatByUserId(String receiveId);
}
