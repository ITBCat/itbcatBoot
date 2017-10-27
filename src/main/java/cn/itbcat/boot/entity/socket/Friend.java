package cn.itbcat.boot.entity.socket;

import cn.itbcat.boot.entity.admin.User;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 860117030 on 2017/10/27.
 */
@Entity
@Table(name = "itbc_chat_friend")
public class Friend {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",unique = true,nullable = false,length = 20)
    private String id;

    @Column(name = "user_id",length = 20)
    private String userId;

    @Column(name = "friend_id",length = 20)
    private String friendId;

    /**
     *  是否通过好友申请 0：是 1：否
     */
    @Column(name = "status")
    private String status;

    @Transient
    private User friend;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
