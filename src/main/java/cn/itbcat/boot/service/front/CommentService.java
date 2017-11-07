package cn.itbcat.boot.service.front;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.common.Message;
import cn.itbcat.boot.entity.common.Result;
import cn.itbcat.boot.entity.front.Comment;
import cn.itbcat.boot.repository.admin.UserRepository;
import cn.itbcat.boot.repository.front.CommentRepositoty;
import cn.itbcat.boot.utils.DateUtils;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 860117030 on 2017/10/19.
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepositoty commentRepositoty;

    @Autowired
    private UserRepository userRepository;

    public Result save(Comment comment) {
        try {
            Comment it = commentRepositoty.save(comment);
            if(null != it){
                User user = userRepository.findOne(comment.getUserId());
                it.setAnthro(user);
                return new Result(ITBC.SUCCESS_CODE,it,new Message());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result(ITBC.ERROR_CODE,null,new Message("error",""));
    }

    public List<Comment> findCommentByArticleId(String id) {
        List<Comment> comments = commentRepositoty.findCommentByArticleId(id);
        for(Comment comment : comments){
            List<Comment> childs = commentRepositoty.findCommentByParentId(comment.getId());
            User user = userRepository.findOne(comment.getUserId());
            if(ITBC.getCurrUserId()==null || user.getUserId().equals(ITBC.getCurrUserId())){
                comment.setIsMine(true);
            }else {
                comment.setIsMine(false);
            }
            comment.setAgo(DateUtils.fromToday(comment.getCreateTime()));
            comment.setAnthro(user);
            if(childs.size()==0){
                comment.setComments(null);
            }else{
                for(Comment child : childs){
                    User u = userRepository.findOne(child.getUserId());
                    if(ITBC.getCurrUserId()==null || user.getUserId().equals(ITBC.getCurrUserId())){
                        child.setIsMine(true);
                    }else {
                        child.setIsMine(false);
                    }
                    child.setAgo(DateUtils.fromToday(child.getCreateTime()));
                    child.setAnthro(u);
                }
                comment.setComments(childs);
            }
        }
        return comments;
    }

    public List<String> findAllCommentByArticleId(String id) {
        Sort sort = new Sort(Sort.Direction.DESC,"updateTime");
        List<Comment> comments = commentRepositoty.findCommentByArticleId(id,sort);
        List<String> commentIds = new ArrayList<String>();
        for(Comment comment : comments){
            commentIds.add(comment.getId());
        }
        return commentIds;
    }

    public Comment get(String commentId) {
        return commentRepositoty.findOne(commentId);
    }
}
