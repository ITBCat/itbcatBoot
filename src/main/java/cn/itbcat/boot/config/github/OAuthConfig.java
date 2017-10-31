package cn.itbcat.boot.config.github;

import cn.itbcat.boot.api.github.api.GithubApi;
import cn.itbcat.boot.api.github.service.CustomOAuthService;
import cn.itbcat.boot.api.github.service.GithubOAuthService;
import cn.itbcat.boot.api.github.service.OAuthServiceDeractor;
import org.scribe.builder.ServiceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OAuthConfig {
    
    private static final String CALLBACK_URL = "%s/oauth/%s/callback";
    
    @Value("${oAuth.github.state}") String state;
    @Value("${oAuth.github.clientId}") String githubClientId;
    @Value("${oAuth.github.clientSecret}") String githubClientSecret;
    @Value("${oAuth.host}") String host;
    
    @Bean
    public GithubApi githubApi(){
        return new GithubApi(state);
    }
    
    @Bean
    public CustomOAuthService getGithubOAuthService(){
        return (CustomOAuthService)new ServiceBuilder()
                .provider(githubApi())
                .apiKey(githubClientId)
                .apiSecret(githubClientSecret)
                .callback(String.format(CALLBACK_URL, host, OAuthTypes.GITHUB))
                .build();
    }
    

}
