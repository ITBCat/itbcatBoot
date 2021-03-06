package cn.itbcat.boot.repository.admin;


import cn.itbcat.boot.entity.admin.OAuthUser;
import cn.itbcat.boot.entity.admin.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthUserRepository extends JpaRepository<OAuthUser, String> {
    
    OAuthUser findByOAuthTypeAndOAuthId(String oAuthType, String oAuthId);

    OAuthUser findByUser(User user);
}
