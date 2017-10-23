package cn.itbcat.boot.controller;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.front.Article;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.service.front.ArticleService;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
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
    public String front(Map<String,Object> data){

        Random r1 = new Random();

        data.put("spanner",r1.nextBoolean());

        List<Article> articles = articleService.findAll();
        data.put("articles",articles);
        data.put("template","index");
        return "front";
    }


    @RequestMapping(value = "/nopermissions")
    public String nopermissions(){
        return "nopermissions";
    }

}
