package cn.itbcat.boot.controller;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.utils.DateEditor;
import cn.itbcat.boot.utils.ITBC;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME;

public class ITBController {
	@Autowired
	protected HttpServletRequest request;


	@Value("${itbc.server.nginx.ipaddress}")
	private String ITBCNginx;

	@Autowired
	protected UserService userService;



	/**
     * 带参重定向
     *
     * @param path
     * @return
     */
    protected String redirect(String path) {
        return "redirect:" + path;
    }

    /**
     * 不带参重定向
     *
     * @param response
     * @param path
     * @return
     */
    protected String redirect(HttpServletResponse response, String path) {
        try {
            response.sendRedirect(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    protected Map<String,Object> dataModel(){

    	Map<String,Object> data = new HashMap<String,Object>();
		User user = null;
		if(StringUtils.isNotBlank(ITBC.getCurrUserId())){
			user = userService.get(ITBC.getCurrUserId());
		}

		boolean flag = false;
		if(null!=user){
			flag = true;
			String _userString = JSON.toJSONString(user);

			JSONObject _user = new JSONObject();
			_user.put("userId",user.getUserId());
			_user.put("username",user.getUsername());
			_user.put("email",user.getEmail());
			_user.put("mobile",user.getMobile());
			_user.put("avatar",user.getAvatar());
			_user.put("profiles",user.getProfiles());
			_user.put("website",user.getWebsite());
			_user.put("gender",user.getGender());
			data.put(ITBC._USER,_user);
			data.put(ITBC.JSON_USER,_user.toJSONString());
		}
		data.put(ITBC.ITBC_FRONT,ITBC.SERVER_NAME_FRONT);
		data.put(ITBC.ITBC_ADMIN,ITBC.SERVER_NAME_ADMIN);
		data.put(ITBC.ITBC_NGINX,ITBCNginx);
		data.put(ITBC.IS_LOGIN,flag);
		HttpSession session=request.getSession();
		data.put(ITBC.LANGUAGE,session.getAttribute(LOCALE_SESSION_ATTRIBUTE_NAME));
    	return data;
	}

}
