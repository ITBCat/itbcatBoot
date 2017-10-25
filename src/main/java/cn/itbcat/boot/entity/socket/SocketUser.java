package cn.itbcat.boot.entity.socket;



import cn.itbcat.boot.entity.admin.User;

import javax.websocket.Session;

/**
 * Created by 岸芷汀翎 on 2017/1/26.
 * Description:
 */
public class SocketUser {
    /**
     * webSocket session
     */
    private Session session;
    /**
     * 用户
     */
    private User user;
    

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    /**
     * 当前用户是否在线
     */
    public boolean isOnline() {
        return UserStatus.NotOnline == this.user.getChatStatus();
    }

}
