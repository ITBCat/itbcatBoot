package cn.itbcat.boot.config.socket;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.socket.*;
import cn.itbcat.boot.repository.socket.ChatRepository;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.service.socket.ChatService;
import cn.itbcat.boot.utils.IMManager;
import cn.itbcat.boot.utils.ITBC;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Date;
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
                for(Chat chat : list) {
                    try {
                        chat.setUserAvatar(userService.get(chat.getUserId()).getAvatar());
                        session.getBasicRemote().sendText(JSON.toJSONString(chat));
                        chat.setSendType(SendType.SENT);
                        chatService.save(chat);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @OnMessage
    public void onMessage(String message,Session session){
        Chat chat = null;
        try{
            //解析前台传过来的数据 chat & User
            SocketMessage sm = JSON.parseObject(message,SocketMessage.class);
            User user = sm.getUser();
            chat = sm.getMessage();
            if(user != null && StringUtils.isNotEmpty(user.getUserId())){
                IMManager.addUser(user, session);
            }
            if (chat == null || StringUtils.isEmpty(chat.getReceiveId())) {
                chat = null;
            } else {
                print("the tm:" + chat.toString());
                chat.setSendType(SendType.UNSENT);
                chat.setTimeStamp(new Date());
                chat.setUserAvatar(user.getAvatar());
                if (MessageType.FRIEND == chat.getType()) {
                    SocketUser su = IMManager.getSocketUserByUserId(chat.getReceiveId());
                    if (su != null && su.getSession() != null && su.getSession().isOpen()) {
                        su.getSession().getBasicRemote().sendText(JSON.toJSONString(chat));
                        System.out.println("send message to "+chat.getReceiveName());
                        chat.setSendType(SendType.SENT);
                    }
                } else if (MessageType.GROUP == chat.getType()) {
                    List<String> ids = sm.getGroupIds();
                    if(ids != null && ids.size() > 0){
                        for (String receiveId : ids) {
                            if(chat.getUserId().equals(receiveId)){
                                continue;
                            }
                            SocketUser su = IMManager.getSocketUserByUserId(receiveId);
                            if(su != null && su.getSession()!= null && su.getSession().isOpen()){
                                try {
                                    su.getSession().getBasicRemote().sendText(JSON.toJSONString(chat));
                                } catch (IOException ie) {
                                    ie.printStackTrace();
                                }
                            }
                        }
                    }
                    chat.setSendType(SendType.SENT);
                }
            }
            if (chat != null && chatService != null) {
                chat.setId(ITBC.getId());
                chatService.save(chat);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @OnError
    public void error(Throwable t) {
        print("连接错误:" + t.getMessage());
        t.printStackTrace();
    }

    @OnClose
    public void close(Session session) {
        SocketUser su = IMManager.getSocketUserBySeesionId(session.getId());
        if (su != null) {
            su.getUser().setChatStatus(UserStatus.NotOnline);
            print(su.getUser().getUsername() + "用户掉线");
        }
        //print("当前在线用户："+LayIMFactory.createManager().getOnlineCount());

    }

    private void print(String message) {
        System.out.println(message);
    }
}
