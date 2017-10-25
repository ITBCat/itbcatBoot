package cn.itbcat.boot.service.socket;

import cn.itbcat.boot.entity.socket.Chat;
import cn.itbcat.boot.entity.socket.MessageType;
import cn.itbcat.boot.entity.socket.SendType;
import cn.itbcat.boot.repository.socket.ChatRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 860117030 on 2017/10/25.
 */
@Service
public class ChatService {

    @Resource
    private ChatRepository chatRepository;

    public Chat save(Chat chat){
        return chatRepository.save(chat);
    }

    public List<Chat> getList(String sendId, SendType sendType, MessageType type){
        return chatRepository.getListByParam(sendId, sendType, type);
    }

}
