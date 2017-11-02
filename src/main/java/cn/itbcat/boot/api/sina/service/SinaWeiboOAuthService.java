package cn.itbcat.boot.api.sina.service;

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

public class SinaWeiboOAuthService extends OAuthServiceDeractor {
    
    private static final String PROTECTED_RESOURCE_URL = "https://api.weibo.com/oauth2/get_token_info";

    public SinaWeiboOAuthService(OAuthService oAuthService) {
        super(oAuthService, OAuthTypes.SINA_WEIBO);
    }

    @Override
    public OAuthUser getOAuthUser(Token accessToken) {
        OAuthRequest request = new OAuthRequest(Verb.POST, PROTECTED_RESOURCE_URL);
        this.signRequest(accessToken, request);
        Response response = request.send();
        OAuthUser oAuthUser = new OAuthUser();
        oAuthUser.setoAuthType(getoAuthType());
        oAuthUser.setoAuthId(JSONPath.eval(JSON.parse(response.getBody()), "$.uid").toString());
        oAuthUser.setUser(new User());
        return oAuthUser;
    }

}
