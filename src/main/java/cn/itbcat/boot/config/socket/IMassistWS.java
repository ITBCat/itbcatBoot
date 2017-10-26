package cn.itbcat.boot.config.socket;

import cn.itbcat.boot.entity.socket.SocketUser;
import cn.itbcat.boot.entity.socket.UserStatus;
import cn.itbcat.boot.utils.IMManager;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 岸芷汀翎 on 2017/1/26.
 * Description:
 */
@ServerEndpoint(value = "/imAssist")
@Component
public class IMassistWS {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("辅助websocket建立");
    }

    @OnMessage
    public void onMessage(String id, Session session) {
        String re = "offline";
        Map<String, String> result = new HashMap<>();
        result.put("id", id);
        if (StringUtils.isNotEmpty(id)) {
            SocketUser su = IMManager.getSocketUserByUserId(id);
            if (su != null) {
//                User user = su.getUser();
//                if (user.getStatus() == UserStatus.Hide || user.getStatus() == UserStatus.Online) {
//                    re = "1";
//                }
            	if(su.getSession() != null && su.getSession().isOpen()){
            		re = UserStatus.Hide.equals(su.getUser().getStatus())?"hide":"online";
            	}
            }
        }
        result.put("online", re);
        try {
            session.getBasicRemote().sendText(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @OnError
    public void error(Throwable t) {
        System.out.println("连接错误:" + t.getMessage());
        t.printStackTrace();
    }

    @OnClose
    public void close(Session session) {
        SocketUser su = IMManager.getSocketUserBySeesionId(session.getId());
        if (su != null) {
            su.getUser().setChatStatus(UserStatus.NotOnline);
            System.out.println(su.getUser().getUsername() + "用户掉线");
        }

    }
}
