package cn.itbcat.boot.api.github.service;

import cn.itbcat.boot.config.github.OAuthTypes;
import cn.itbcat.boot.entity.admin.OAuthUser;
import cn.itbcat.boot.entity.admin.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.*;
import org.scribe.oauth.OAuth20ServiceImpl;
import org.scribe.oauth.OAuthService;

public class GithubOAuthService extends OAuth20ServiceImpl implements CustomOAuthService {

    private static final String PROTECTED_RESOURCE_URL = "https://api.github.com/user";

    private final DefaultApi20 api;
    private final OAuthConfig config;
    private final String authorizationUrl;

    public GithubOAuthService(DefaultApi20 api, OAuthConfig config){
        super(api,config);
        this.api=api;
        this.config=config;
        this.authorizationUrl=getAuthorizationUrl(null);
    }

    @Override
    public String getoAuthType() {
        return OAuthTypes.GITHUB;
    }

    @Override
    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    @Override
    public OAuthUser getOAuthUser(Token accessToken) {
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
        this.signRequest(accessToken, request);
        Response response = request.send();
        OAuthUser oAuthUser = new OAuthUser();
        oAuthUser.setoAuthType(getoAuthType());
        Object result = JSON.parse(response.getBody());
        oAuthUser.setoAuthId(JSONPath.eval(result, "$.id").toString());
        oAuthUser.setUser(new User());
        oAuthUser.getUser().setUsername(JSONPath.eval(result, "$.login").toString());
        return oAuthUser;
    }

    @Override
    public String getBtnClass() {
        return null;
    }


}
