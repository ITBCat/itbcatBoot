package cn.itbcat.boot.config.intercepter;

import cn.itbcat.boot.entity.User;
import cn.itbcat.boot.utils.ITBC;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Intercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
		 return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
		request.setAttribute("", request.getContextPath());
		Subject subject = SecurityUtils.getSubject();
		User user = ITBC.getCurrUser();
		boolean flag = false;
		if(null!=user){
			flag = true;
			modelAndView.addObject("_user",user);
		}
		modelAndView.addObject("isLogin",flag);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}


}
