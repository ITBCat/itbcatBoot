package cn.itbcat.boot.controller.front;

import cn.itbcat.boot.entity.common.Result;
import cn.itbcat.boot.entity.front.Comment;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.service.admin.UserService;
import cn.itbcat.boot.service.front.CommentService;
import cn.itbcat.boot.utils.ITBC;
import freemarker.template.utility.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    @ResponseBody
    @RequiresPermissions("user:login:comment")
    public Result add(HttpServletRequest request, HttpServletResponse response){
        String content = request.getParameter("content");
        String articleId = request.getParameter("articleId");
        String parentId = request.getParameter("parentId");
        User user = ITBC.getCurrUser();
        Comment comment = new Comment();
        comment.setId(ITBC.getId());
        comment.setUserId(user.getUserId());
        comment.setArticleId(articleId);
        comment.setContent(content);
        if(StringUtils.isNotBlank(parentId)){
            comment.setParentId(parentId);
        }else{
            comment.setParentId(null);
        }
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        return commentService.save(comment);
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("user:login:comment-user")
    public Result user(@RequestParam(value = "commentId") String commentId){
        if(StringUtils.isBlank(commentId))return new Result(ITBC.ERROR_CODE,null,"commentId is null");
        Comment comment = commentService.get(commentId);
        User user = userService.get(comment.getUserId());
        if(null == user)return new Result(ITBC.ERROR_CODE,null,"user is not found");
        return new Result(ITBC.SUCCESS_CODE,user,"success");
    }

}
