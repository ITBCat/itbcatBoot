package cn.itbcat.boot.repository.front;

import cn.itbcat.boot.entity.front.ArticleSearch;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 860117030 on 2017/10/14.
 */
@Repository
public interface ArticleSearchRepository extends ElasticsearchRepository<ArticleSearch,Long> {
    List<ArticleSearch> findByTitleLike(String title);
}
