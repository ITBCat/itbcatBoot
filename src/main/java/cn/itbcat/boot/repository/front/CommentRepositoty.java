package cn.itbcat.boot.repository.front;

import cn.itbcat.boot.entity.front.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 860117030 on 2017/10/19.
 */
@Repository
@Transactional
public interface CommentRepositoty extends JpaRepository<Comment,String>,CrudRepository<Comment,String> {
    @Query(value = "SELECT * FROM itbc_comment WHERE article_id = ?1 AND parent_id IS NULL ORDER BY update_time DESC ",nativeQuery = true)
    List<Comment> findCommentByArticleId(String id);

    List<Comment> findCommentByParentId(String parentId);

    List<Comment> findCommentByArticleId(String id, Sort sort);
}
