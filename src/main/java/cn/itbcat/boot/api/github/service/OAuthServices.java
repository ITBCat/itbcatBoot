package cn.itbcat.boot.api.github.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OAuthServices {
    
    @Autowired
    List<CustomOAuthService> customOAuthServices;

    public CustomOAuthService getOAuthService(String type) {
        CustomOAuthService oAuthService = null;
        for (CustomOAuthService customOAuthService : customOAuthServices) {
            if (customOAuthService.getoAuthType().equals(type)) {
                oAuthService = customOAuthService;
                break;
            }
        }
        return oAuthService;
    }
    public List<CustomOAuthService> getAllOAuthServices() {
        return customOAuthServices;
    }

}
