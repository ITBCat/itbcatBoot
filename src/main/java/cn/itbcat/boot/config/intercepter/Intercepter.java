package cn.itbcat.boot.config.intercepter;

import cn.itbcat.boot.entity.User;
import cn.itbcat.boot.utils.ITBC;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Intercepter implements HandlerInterceptor {

	@Value("${itbc.server.front}")
	private String front;
	@Value("${itbc.server.admin}")
	private String admin;

	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
		 return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
		Subject subject = SecurityUtils.getSubject();
		User user = ITBC.getCurrUser();
		if(null != modelAndView){
			boolean flag = false;
			if(null!=user){
				flag = true;
				modelAndView.addObject("_user",user);
			}
			modelAndView.addObject("ITBCFront",front);
			modelAndView.addObject("ITBCAdmin",admin);
			modelAndView.addObject("isLogin",flag);
		}

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}


}
