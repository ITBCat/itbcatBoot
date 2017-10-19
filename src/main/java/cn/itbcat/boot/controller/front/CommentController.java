package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.entity.front.Comment;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * Created by 860117030 on 2017/10/19.
 */

@Controller
@RequestMapping(ITBC.SERVER_NAME_FRONT+"/comment")
public class CommentController {

    @RequestMapping("/add")
    @ResponseBody
    public Map<String,Object> add(HttpServletRequest request, HttpServletResponse response,Map<String,Object> data){
        String content = request.getParameter("content");
        String articleId = request.getParameter("articleId");
        User user = ITBC.getCurrUser();
        Comment comment = new Comment();
        comment.setId(ITBC.getId());
        comment.setUserId(user.getUserId());
        comment.setArticleId(articleId);
        comment.setContent(content);
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());

        return data;
    }


}
