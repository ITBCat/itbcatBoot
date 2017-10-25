package cn.itbcat.boot.config.socket;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.socket.Chat;
import cn.itbcat.boot.entity.socket.MessageType;
import cn.itbcat.boot.entity.socket.SendType;
import cn.itbcat.boot.entity.socket.UserStatus;
import cn.itbcat.boot.repository.socket.ChatRepository;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.service.socket.ChatService;
import cn.itbcat.boot.utils.IMManager;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * Created by 860117030 on 2017/10/25.
 */
@Lazy(value=true)
@Component
@ServerEndpoint("/im/{uid}")
public class IMSocket {

    @Autowired
    private ChatService chatService;
    @Autowired
    private UserService userService;

    @OnOpen
    public void onOpen(Session session, @PathParam("uid")String uid){
        if(null == chatService){
            chatService = WebSocketConfig.appContext.getBean(ChatService.class);
        }
        if(null == userService){
            userService = WebSocketConfig.appContext.getBean(UserService.class);
        }
        User user = userService.get(uid);
        user.setChatStatus(UserStatus.Online);

        //保存在线列表
        IMManager.addUser(user, session);
        print("当前在线用户：" + IMManager.getOnlineNum());
        print("缓存中的用户个数：" + IMManager.getCashNum());

        try {
            List<Chat> list = chatService.getList(uid, SendType.UNSENT, MessageType.FRIEND);
            if(list != null && list.size() > 0){
                list.stream().forEach(chat -> {
                    try {
                        session.getBasicRemote().sendText(JSON.toJSONString(chat));
                        chat.setSendType(SendType.SENT);
                        chatService.save(chat);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
