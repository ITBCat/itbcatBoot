package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.front.Article;
import cn.itbcat.boot.entity.front.Comment;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.service.front.ArticleService;
import cn.itbcat.boot.service.front.CommentService;
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
    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/article/{id}",method = RequestMethod.GET)
    private String article(Map<String,Object> data, @PathVariable String id){
        Article article = articleService.get(id);
        if(null != article) {
            List<Comment> comments = commentService.findCommentByArticleId(id);
            article.setComments(comments);
            User anthor = userService.get(article.getUserid());
            article.setAnthor(anthor);
            data.put("article", article);
            List<String> commentIds = commentService.findAllCommentByArticleId(id);
            data.put("commentIds", commentIds.toString());
            data.put("length", commentIds.size());
            data.put("template", "article");
            return "front";
        }else {
            return "404";
        }
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
