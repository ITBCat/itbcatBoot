package cn.itbcat.boot.repository.front;

import cn.itbcat.boot.entity.front.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 860117030 on 2017/10/14.
 */
@Repository
@Transactional
public interface ArticleRepository extends JpaRepository<Article,String>,CrudRepository<Article,String> {

}
