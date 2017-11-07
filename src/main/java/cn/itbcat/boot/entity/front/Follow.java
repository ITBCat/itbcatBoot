package cn.itbcat.boot.entity.front;

import cn.itbcat.boot.entity.admin.User;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 860117030 on 2017/11/7.
 */
@Entity
@Table(name = "itbc_follow")
public class Follow {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",unique = true,nullable = false,length = 20)
    private String id;

    @Column(name = "user_id",nullable = false,length = 20)
    private String userId;

    @Column(name = "follower_id",nullable = false,length = 20)
    private String followId;

    @Transient
    private User user;

    @Transient
    private List<User> followers;

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

    public String getFollowId() {
        return followId;
    }

    public void setFollowId(String followId) {
        this.followId = followId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
}
