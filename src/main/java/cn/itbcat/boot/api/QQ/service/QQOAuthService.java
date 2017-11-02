package cn.itbcat.boot.api.QQ.service;

import cn.itbcat.boot.api.OAuthServiceDeractor;
import cn.itbcat.boot.config.oauth.OAuthTypes;
import cn.itbcat.boot.entity.admin.OAuthUser;
import cn.itbcat.boot.entity.admin.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

public class QQOAuthService extends OAuthServiceDeractor {
    
    private static final String PROTECTED_RESOURCE_URL = "https://graph.qq.com/oauth2.0/me";

    public QQOAuthService(OAuthService oAuthService) {
        super(oAuthService, OAuthTypes.QQ);
    }

    @Override
    public OAuthUser getOAuthUser(Token accessToken) {
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
        this.signRequest(accessToken, request);
        Response response = request.send();
        OAuthUser oAuthUser = new OAuthUser();
        oAuthUser.setoAuthType(getoAuthType());
        Object result = JSON.parse(response.getBody().substring(9, response.getBody().length() - 3));
        oAuthUser.setoAuthId(JSONPath.eval(result, "$.openid").toString());
        oAuthUser.setUser(new User());
        return oAuthUser;
    }

}
