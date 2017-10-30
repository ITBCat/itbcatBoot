package cn.itbcat.boot.config.shiro;

import cn.itbcat.boot.utils.ITBC;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.ShiroHttpSession;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
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
	 * rememberMe管理器, cipherKey生成见{@code Base64Test.java}
	 */
	@Bean
	public CookieRememberMeManager rememberMeManager(SimpleCookie rememberMeCookie) {
		CookieRememberMeManager manager = new CookieRememberMeManager();
		manager.setCipherKey(Base64.decode("Z3VucwAAAAAAAAAAAAAAAA=="));
		manager.setCookie(rememberMeCookie);
		return manager;
	}

	/**
	 * 记住密码Cookie
	 */
	@Bean
	public SimpleCookie rememberMeCookie() {
		SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
		simpleCookie.setHttpOnly(true);
		simpleCookie.setMaxAge(7 * 24 * 60 * 60);//7天
		return simpleCookie;
	}
	/**
	 * @see DefaultWebSessionManager
	 * @return
	 */
	@Bean(name="sessionManager")
	public DefaultWebSessionManager defaultWebSessionManager() {
		System.out.println("ShiroConfiguration.defaultWebSessionManager()");
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		//sessionManager.setSessionDAO(new CustomSessionDAO());
		sessionManager.setCacheManager(cacheManager());
		//单位为毫秒（1秒=1000毫秒） 3600000毫秒为1个小时
		sessionManager.setSessionValidationInterval(3600000*12);
		//3600000 milliseconds = 1 hour
		sessionManager.setGlobalSessionTimeout(3600000*12);
		sessionManager.setDeleteInvalidSessions(true);
		sessionManager.setSessionValidationSchedulerEnabled(true);
		Cookie cookie = new SimpleCookie(ShiroHttpSession.DEFAULT_SESSION_ID_NAME);
		cookie.setName("ITBC");
		cookie.setHttpOnly(true);
		sessionManager.setSessionIdCookie(cookie);
		return sessionManager;
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
		sm.setSessionManager(defaultWebSessionManager());
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
		filterMap.put("/i18n/**", "anon");
		filterMap.put("/images/**", "anon");
		filterMap.put("/send", "anon");

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
