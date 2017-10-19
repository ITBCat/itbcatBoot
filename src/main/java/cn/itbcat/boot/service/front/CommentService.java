package cn.itbcat.boot.service.front;

import cn.itbcat.boot.entity.common.Result;
import cn.itbcat.boot.entity.front.Comment;
import cn.itbcat.boot.repository.front.CommentRepositoty;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 860117030 on 2017/10/19.
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepositoty commentRepositoty;

    public Result save(Comment comment) {
        Result result = new Result();
        try {
            Comment it = commentRepositoty.save(comment);
            if(null != it){
                result.setCode(ITBC.SUCCESS_CODE);
                result.setData(it);
                result.setMessage("success");
            }else {
                result.setCode(ITBC.ERROR_CODE);
                result.setMessage("error");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(ITBC.ERROR_CODE);
            result.setMessage(e.getCause().getMessage().toString());
        }
        return result;
    }

    public List<Comment> findCommentByArticleId(String id) {
        Sort sort = new Sort(Sort.Direction.DESC, "updateTime");
        List<Comment> comments = commentRepositoty.findCommentByArticleId(id,sort);
        for(Comment comment : comments){
            List<Comment> childs = commentRepositoty.findCommentByParentId(comment.getId());
            if(childs.size()==0){
                comment.setComments(null);
            }else{
                comment.setComments(childs);
            }
        }
        return comments;
    }

}
