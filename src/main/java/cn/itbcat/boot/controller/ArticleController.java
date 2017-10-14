package cn.itbcat.boot.controller;

import cn.itbcat.boot.entity.Article;
import cn.itbcat.boot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by 860117030 on 2017/10/12.
 */
@Controller
@RequestMapping(value = "/f")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/article",method = RequestMethod.GET)
    private String article(){
        return "module/front/article";
    }

    @RequestMapping(value = "/put",method = RequestMethod.GET)
    public String toPut(Map<String,Object> data){
        return "module/front/put";
    }

    @RequestMapping(value = "/put",method = RequestMethod.POST)
    public String put(@ModelAttribute Article article, HttpServletRequest request){

    try{
        articleService.save(article);
    }catch (Exception e){
        e.printStackTrace();
    }
        return "module/front/put";
    }


}
