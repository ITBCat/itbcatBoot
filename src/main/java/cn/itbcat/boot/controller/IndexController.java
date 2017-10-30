package cn.itbcat.boot.controller;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.front.Article;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.service.front.ArticleService;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;


/**
 * Created by 860117030 on 2017/9/5.
 */
@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = ITBC.SERVER_NAME_ADMIN+"/admin",method = RequestMethod.GET)
    public String index(Map<String, Object> dataModel){
        User user = ITBC.getCurrUser();
        if(null != user && ITBC.SUPER_ADMIN.equals(user.getIsAdmin())){
            return "redirect:"+ITBC.SERVER_NAME_ADMIN+"/healths";
        } else {
            dataModel.put("template","index");
            return "index";
        }

    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String front(Map<String,Object> data,@PageableDefault(sort = {"id"},size = 20,direction = Sort.Direction.DESC) Pageable pageable){

        Random r1 = new Random();

        data.put("spanner",r1.nextBoolean());

        Page<Article> articles = articleService.findAll(pageable);
        data.put("articles",articles.getContent());
        data.put("curNum",articles.getTotalPages());
        data.put("paginationPageCount",articles.getTotalElements());
        data.put("template","index");
        return "front";
    }


    @RequestMapping(value = "/nopermissions")
    public String nopermissions(){
        return "nopermissions";
    }

    @RequestMapping("/changeSessionLanauage")
    public String changeSessionLanauage(HttpServletRequest request, HttpServletResponse response,
                                        String lang){
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if("zh".equals(lang)){
            localeResolver.setLocale(request, response, new Locale("zh", "CN"));
        }else if("en".equals(lang)){
            localeResolver.setLocale(request, response, new Locale("en", "US"));
        }
        return "redirect:/";
    }

}
