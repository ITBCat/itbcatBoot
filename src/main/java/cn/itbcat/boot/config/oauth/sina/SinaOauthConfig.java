package cn.itbcat.boot.config.oauth.sina;

import cn.itbcat.boot.api.OAuthServiceDeractor;
import cn.itbcat.boot.api.sina.service.SinaWeiboOAuthService;
import cn.itbcat.boot.config.oauth.OAuthTypes;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.SinaWeiboApi20;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 860117030 on 2017/11/2.
 */
@Configuration
public class SinaOauthConfig {

    @Value("${oAuth.host}")
    private String HOST;

    private String CALLBACK_URL = HOST + "/oauth/%s/callback";

    @Value("${oAuth.sina.appKey}")
    private String sinaAppKey;

    @Value("${oAuth.sina.appSecret}")
    private String sinaAppSecret;

    @Bean
    public OAuthServiceDeractor getSinaOAuthService(){
        return new SinaWeiboOAuthService(new ServiceBuilder()
                .provider(SinaWeiboApi20.class)
                .apiKey(sinaAppKey)
                .apiSecret(sinaAppSecret)
                .callback(String.format(CALLBACK_URL, OAuthTypes.SINA_WEIBO))
                .build());
    }

}
