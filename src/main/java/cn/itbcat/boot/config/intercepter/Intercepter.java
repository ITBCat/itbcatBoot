package cn.itbcat.boot.config.intercepter;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.utils.ITBC;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Component
public class Intercepter implements HandlerInterceptor {

	@Value("${itbc.server.nginx.ipaddress}")
	private String ITBCNginx;

	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
		 return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
						   HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
//		User user = null;
//		if(StringUtils.isNotBlank(ITBC.getCurrUserId())){
//			user = userService.get(ITBC.getCurrUserId());
//		}
//
//		if(null != modelAndView){
//			boolean flag = false;
//			if(null!=user){
//				flag = true;
//				String _userString = JSON.toJSONString(user);
//				JSONObject _user = JSONObject.parseObject(_userString);
//				modelAndView.addObject(ITBC._USER,_user);
//				modelAndView.addObject(ITBC.JSON_USER,_userString);
//			}
//			modelAndView.addObject(ITBC.ITBC_FRONT,ITBC.SERVER_NAME_FRONT);
//			modelAndView.addObject(ITBC.ITBC_ADMIN,ITBC.SERVER_NAME_ADMIN);
//			modelAndView.addObject(ITBC.ITBC_NGINX,ITBCNginx);
//			modelAndView.addObject(ITBC.IS_LOGIN,flag);
//		}

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}


}
