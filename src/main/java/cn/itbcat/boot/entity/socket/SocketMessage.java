package cn.itbcat.boot.entity.socket;



import cn.itbcat.boot.entity.admin.User;
import org.springframework.web.socket.TextMessage;

import java.util.List;


/**
 * Created by 岸芷汀翎 on 2017/1/26.
 * Description:
 */
public class SocketMessage implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private User user;
    private Chat message;
    private List<String> groupIds;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chat getMessage() {
        return message;
    }

    public void setMessage(Chat message) {
        this.message = message;
    }

	public List<String> getGroupIds() {
		return groupIds;
	}

	public void setGroupIds(List<String> groupIds) {
		this.groupIds = groupIds;
	}
    
    
}
