package cn.itbcat.boot.api.github.service;

import cn.itbcat.boot.entity.admin.OAuthUser;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;
import org.springframework.stereotype.Component;

/**
 * Created by billJiang on 2017/1/15.
 * e-mail:jrn1012@petrochina.com.cn qq:475572229
 */
@Component
public interface CustomOAuthService extends OAuthService {
    String getoAuthType();
    String getAuthorizationUrl();
    OAuthUser getOAuthUser(Token accessToken);
    String getBtnClass();
}
