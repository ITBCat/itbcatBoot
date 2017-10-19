package cn.itbcat.boot.repository.front;

import cn.itbcat.boot.entity.front.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 860117030 on 2017/10/19.
 */
@Transactional
public interface CommentRepositoty extends JpaRepository<Comment,String>,CrudRepository<Comment,String> {
    List<Comment> findCommentByArticleId(String id,Sort sort);

    List<Comment> findCommentByParentId(String parentId);
}
