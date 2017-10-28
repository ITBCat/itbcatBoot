package cn.itbcat.boot.service.socket;

import cn.itbcat.boot.entity.socket.Chat;
import cn.itbcat.boot.entity.socket.MessageType;
import cn.itbcat.boot.entity.socket.SendType;
import cn.itbcat.boot.repository.socket.ChatRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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

    public List<Chat> getList(String receiveId, SendType sendType, MessageType type){
        return chatRepository.getListByParam(receiveId, sendType, type);
    }

    public List<Chat> findChatByRidAndUid(String receiveId, String currUserId) {
        List<Chat> rightlist = chatRepository.findChatByReceiveId(receiveId);
        List<Chat> leftlist = chatRepository.findChatByUserId(receiveId);

        rightlist.addAll(leftlist);

        // 按点击数倒序
        Collections.sort(rightlist, new Comparator<Chat>() {
            public int compare(Chat arg0, Chat arg1) {
                Date d1 = arg0.getTimeStamp();
                Date d2 = arg1.getTimeStamp();
                if (d2.getTime() > d1.getTime()) {
                    return -1;
                } else if (d2.getTime() == d1.getTime()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        for(Chat c: rightlist){
            if(c.getUserId().equals(currUserId)){
                c.setPositon("r");
            }else {
                c.setPositon("l");
            }
        }
        return rightlist;
    }
}
