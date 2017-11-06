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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ITBController {
	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;


	@Value("${itbc.server.nginx.ipaddress}")
	private String ITBCNginx;

	@Autowired
	private UserService userService;

	@InitBinder
    protected void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        webDataBinder.registerCustomEditor(Date.class, new DateEditor(true));
    }

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

    /**
     * 获取分页请求
     * @return
     */
    protected PageRequest getPageRequest(){
    	int page = 1;
    	int size = 10;
    	Sort sort = null;
    	try {
    		String sortName = request.getParameter("sortName");
    		String sortOrder = request.getParameter("sortOrder");
    		if(StringUtils.isNoneBlank(sortName) && StringUtils.isNoneBlank(sortOrder)){
    			if(sortOrder.equalsIgnoreCase("desc")){
    				sort = new Sort(Direction.DESC, sortName);
    			}else{
    				sort = new Sort(Direction.ASC, sortName);
    			}
    		}
    		if(!org.springframework.util.StringUtils.isEmpty(request.getParameter("pageNumber"))){
				page = Integer.parseInt(request.getParameter("pageNumber")) - 1;
				size = Integer.parseInt(request.getParameter("pageSize"));
			}

    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	PageRequest pageRequest = new PageRequest(page, size, sort);
    	return pageRequest;
    }

    /**
     * 获取分页请求
     * @param sort 排序条件
     * @return
     */
    protected PageRequest getPageRequest(Sort sort){
    	int page = 0;
    	int size = 10;
    	try {
    		if (null==sort) {
				String sortName = request.getParameter("sortName");
				String sortOrder = request.getParameter("sortOrder");
				if (StringUtils.isNoneBlank(sortName) && StringUtils.isNoneBlank(sortOrder)) {
					if (sortOrder.equalsIgnoreCase("desc")) {
						sort.and(new Sort(Direction.DESC, sortName));
					} else {
						sort.and(new Sort(Direction.ASC, sortName));
					}
				}
			}
			if(!org.springframework.util.StringUtils.isEmpty(request.getParameter("pageNumber"))){
				page = Integer.parseInt(request.getParameter("pageNumber")) - 1;
				size = Integer.parseInt(request.getParameter("pageSize"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	PageRequest pageRequest = new PageRequest(page, size, sort);
    	return pageRequest;
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
			JSONObject _user = JSONObject.parseObject(_userString);
			data.put(ITBC._USER,_user);
			data.put(ITBC.JSON_USER,_userString);
		}
		data.put(ITBC.ITBC_FRONT,ITBC.SERVER_NAME_FRONT);
		data.put(ITBC.ITBC_ADMIN,ITBC.SERVER_NAME_ADMIN);
		data.put(ITBC.ITBC_NGINX,ITBCNginx);
		data.put(ITBC.IS_LOGIN,flag);

    	return data;
	}

}
