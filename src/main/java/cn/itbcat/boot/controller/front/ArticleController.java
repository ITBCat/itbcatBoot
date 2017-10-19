package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.entity.front.Article;
import cn.itbcat.boot.service.front.ArticleService;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 860117030 on 2017/10/12.
 */
@Controller
@RequestMapping(ITBC.SERVER_NAME_FRONT)
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/article/{id}",method = RequestMethod.GET)
    private String article(Map<String,Object> data, @PathVariable String id){
        data.put("article",articleService.get(id));
        List<Article> articles = articleService.findAll();
        data.put("data",articles);
        data.put("parents",articles.size());
        data.put("comments",articles.size());
        data.put("template","article");
        return "front";
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
