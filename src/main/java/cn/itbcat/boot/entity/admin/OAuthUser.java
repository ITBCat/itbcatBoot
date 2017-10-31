package cn.itbcat.boot.entity.admin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by 860117030 on 2017/10/31.
 */
@Entity
@Table(name = "sys_oauth_user")
public class OAuthUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @OneToOne
    private User user;

    private String oAuthType;

    private String oAuthId;

    private String oAuthPas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getoAuthType() {
        return oAuthType;
    }

    public void setoAuthType(String oAuthType) {
        this.oAuthType = oAuthType;
    }

    public String getoAuthId() {
        return oAuthId;
    }

    public void setoAuthId(String oAuthId) {
        this.oAuthId = oAuthId;
    }

    public String getoAuthPas() {
        return oAuthPas;
    }

    public void setoAuthPas(String oAuthPas) {
        this.oAuthPas = oAuthPas;
    }
}
