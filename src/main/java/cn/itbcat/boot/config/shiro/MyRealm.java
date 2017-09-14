package cn.itbcat.boot.config.shiro;

import cn.itbcat.boot.entity.User;
import cn.itbcat.boot.service.UserService;

import cn.itbcat.boot.service.ShiroService;
import cn.itbcat.boot.utils.ITBC;
import cn.itbcat.boot.utils.MD5;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.AllowAllCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 
 * @author SPPan
 *
 */
@Component
public class MyRealm extends AuthorizingRealm {

	public MyRealm(){
		super(new AllowAllCredentialsMatcher());
        setAuthenticationTokenClass(UsernamePasswordToken.class);

        //FIXME: 暂时禁用Cache
        setCachingEnabled(false);
	}
	
	@Autowired
	private UserService userService;

	@Autowired
	private ShiroService shiroService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		User user = (User)principals.getPrimaryPrincipal();
		String userId = user.getUserId();

		//用户权限列表
		Set<String> permsSet = shiroService.getUserPermissions(userId);

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		
		User user = userService.getUserByEmail(username);
		
		String password = new String((char[]) token.getCredentials());
		String pass = new Sha256Hash(password, MD5.encodeSHAString(ITBC.PRODUCT_NAME)).toHex().toString();

		// 账号不存在
		if (user == null) {
			throw new UnknownAccountException("用户不存在");
		}

		// 密码错误
		if (!pass.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("账号或密码不正确");
		}
		// 账号锁定
//		if (user.getLocked() == 1) {
//			throw new LockedAccountException("账号已被锁定,请联系管理员");
//		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());

		return info;
	}

}
