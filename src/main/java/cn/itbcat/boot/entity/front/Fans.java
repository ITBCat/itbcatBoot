package cn.itbcat.boot.entity.front;

import cn.itbcat.boot.entity.admin.User;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Seven on 2017/11/7.
 */
@Entity
@Table(name = "itbc_fans")
public class Fans {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",unique = true,nullable = false,length = 20)
    private String id;

    @Column(name = "user_id",nullable = false,length = 20)
    private String userId;

    @Column(name = "fans_id",nullable = false,length = 20)
    private String fansId;

    @Transient
    private User user;

    @Transient
    private List<User> fans;

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

    public String getFansId() {
        return fansId;
    }

    public void setFansId(String fansId) {
        this.fansId = fansId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getFans() {
        return fans;
    }

    public void setFans(List<User> fans) {
        this.fans = fans;
    }
}
