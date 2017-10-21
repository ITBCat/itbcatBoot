package cn.itbcat.boot.config.shiro;

import cn.itbcat.boot.utils.ITBC;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Import(ShiroManager.class)
public class ShiroConfig {

	@Bean(name = "realm")
	@DependsOn("lifecycleBeanPostProcessor")
	@ConditionalOnMissingBean
	public Realm realm() {
		return new MyRealm();
	}
	
	 /**
     * 用户授权信息Cache
     */
    @Bean(name = "shiroCacheManager")
    @ConditionalOnMissingBean
    public CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }

    @Bean(name = "securityManager")
    @ConditionalOnMissingBean
    public DefaultSecurityManager securityManager() {
        DefaultSecurityManager sm = new DefaultWebSecurityManager();
        sm.setCacheManager(cacheManager());
        return sm;
    }

	@Bean(name = "shiroFilter")
	@DependsOn("securityManager")
	@ConditionalOnMissingBean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultSecurityManager securityManager, Realm realm) {
		securityManager.setRealm(realm);

		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager);
		shiroFilter.setLoginUrl("/login");
		shiroFilter.setSuccessUrl("/");

		Map<String, String> filterMap = new HashMap<String, String>();
		filterMap.put("/static/**", "anon");
		filterMap.put("/images/**", "anon");

		filterMap.put("/login", "anon");
		filterMap.put("/lock", "anon");
		filterMap.put("/mail/**", "anon");
		filterMap.put("/itbc/**", "anon");
		filterMap.put("/swagger-ui.html", "anon");
		filterMap.put("/swagger-resources/**", "anon");
		filterMap.put("/register", "anon");
		filterMap.put("/upload", "anon");
		filterMap.put("/admin/nopermissions", "anon");
		filterMap.put(ITBC.SERVER_NAME_ADMIN+"/**", "authc");

		//filterMap.put("/**", "authc");
		shiroFilter.setUnauthorizedUrl("/login");
		shiroFilter.setFilterChainDefinitionMap(filterMap);
		return shiroFilter;
	}
}
