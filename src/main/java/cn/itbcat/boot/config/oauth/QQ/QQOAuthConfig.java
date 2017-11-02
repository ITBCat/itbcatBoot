package cn.itbcat.boot.config.oauth.QQ;

import cn.itbcat.boot.api.OAuthServiceDeractor;
import cn.itbcat.boot.api.QQ.api.QQApi;
import cn.itbcat.boot.api.QQ.service.QQOAuthService;
import cn.itbcat.boot.config.oauth.OAuthTypes;
import org.scribe.builder.ServiceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QQOAuthConfig {

    @Value("${oAuth.host}")
    private String HOST;

    private String CALLBACK_URL = HOST + "/oauth/%s/callback";
    
    @Value("${oAuth.qq.state}") String state;
    @Value("${oAuth.qq.appId}") String qqAppId;
    @Value("${oAuth.qq.appKey}") String qqAppKey;
    
    @Bean
    public QQApi qqApi(){
        return new QQApi(state);
    }
    
    @Bean
    public OAuthServiceDeractor getQQOAuthService(){
        return new QQOAuthService(new ServiceBuilder()
                .provider(qqApi())
                .apiKey(qqAppId)
                .apiSecret(qqAppKey)
                .callback(String.format(CALLBACK_URL, OAuthTypes.QQ))
                .build());
    }

}
