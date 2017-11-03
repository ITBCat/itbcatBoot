package cn.itbcat.boot.service.front;

import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.entity.front.Article;
import cn.itbcat.boot.entity.front.ArticleSearch;
import cn.itbcat.boot.repository.admin.UserRepository;
import cn.itbcat.boot.repository.front.ArticleRepository;
import cn.itbcat.boot.repository.front.ArticleSearchRepository;
import cn.itbcat.boot.utils.DateUtils;
import cn.itbcat.boot.utils.ITBC;
import cn.itbcat.boot.utils.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 860117030 on 2017/10/14.
 */
@Service
public class ArticleSearchService {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;

    Pageable pageable = new PageRequest(ITBC.PAGE_NUM, ITBC.PAGE_SIZE);

    public void save(Article article) {
        ArticleSearch articleSearch = new ArticleSearch();
        User user = ITBC.getCurrUser();
        articleSearch.setId(ITBC.getLongId());
        articleSearch.setArticleId(article.getId());
        articleSearch.setHtml(article.getHtml());
        articleSearch.setAvatar(user.getAvatar());
        articleSearch.setMd(article.getMd());
        articleSearch.setTitle(article.getTitle());
        articleSearch.setUserid(user.getUserId());
        articleSearch.setDate(new Date());
        articleSearchRepository.save(articleSearch);
    }

    public List<ArticleSearch> search(String q) {

        List<ArticleSearch> list = articleSearchRepository.findByTitleLike(q);

        return list;
    }

    public List<ArticleSearch> search(Integer pageNumber,
                                 Integer pageSize,
                                 String searchContent) {
        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);

        // Function Score Query
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("cityname", searchContent)),
                        ScoreFunctionBuilders.weightFactorFunction(1000))
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("description", searchContent)),
                        ScoreFunctionBuilders.weightFactorFunction(100));

        // 创建搜索 DSL 查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();


        Page<ArticleSearch> searchPageResults = articleSearchRepository.search(searchQuery);
        return searchPageResults.getContent();
    }

    /**
     * 根据搜索词构造搜索查询语句
     *
     * 代码流程：
     *      - 权重分查询
     *      - 短语匹配
     *      - 设置权重分最小值
     *      - 设置分页参数
     *
     * @param pageNumber 当前页码
     * @param pageSize 每页大小
     * @param searchContent 搜索内容
     * @return
     */
    private SearchQuery getCitySearchQuery(Integer pageNumber, Integer pageSize,String searchContent) {
        // 短语匹配到的搜索词，求和模式累加权重分
        // 权重分查询 https://www.elastic.co/guide/cn/elasticsearch/guide/current/function-score-query.html
        //   - 短语匹配 https://www.elastic.co/guide/cn/elasticsearch/guide/current/phrase-matching.html
        //   - 字段对应权重分设置，可以优化成 enum
        //   - 由于无相关性的分值默认为 1 ，设置权重分最小值为 10
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.matchPhraseQuery("name", searchContent),
                        ScoreFunctionBuilders.weightFactorFunction(1000))
                .add(QueryBuilders.matchPhraseQuery("description", searchContent),
                        ScoreFunctionBuilders.weightFactorFunction(500))
                .scoreMode(ITBC.SCORE_MODE_SUM).setMinScore(ITBC.MIN_SCORE);

        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
    }

}
