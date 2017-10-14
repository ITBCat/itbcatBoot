package cn.itbcat.boot.repository;

import cn.itbcat.boot.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 860117030 on 2017/10/14.
 */
@Transactional
public interface ArticleRepository extends JpaRepository<Article,String>,CrudRepository<Article,String> {
}
