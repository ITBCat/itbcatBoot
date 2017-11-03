package cn.itbcat.boot.service.front;

import cn.itbcat.boot.entity.front.Article;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.repository.admin.UserRepository;
import cn.itbcat.boot.repository.front.ArticleRepository;
import cn.itbcat.boot.utils.DateUtils;
import cn.itbcat.boot.utils.ITBC;
import cn.itbcat.boot.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 860117030 on 2017/10/14.
 */
@Service
public class ArticleService {

    //这里的单引号不能少，否则会报错，被识别是一个对象;
    public static final String CACHE_KEY = "'CACHE_ARTICLE'";

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @CacheEvict(value=ITBC.CACHE_NAME,key=CACHE_KEY)
    public Article save(Article article) {
        User user = ITBC.getCurrUser();
        article.setId(ITBC.getId());
        article.setUserid(user.getUserId());
        article.setDate(new Date());
        return articleRepository.save(article);
    }

    @Cacheable(value=ITBC.CACHE_NAME,key="'CACHE_ARTICLE_'+#articleId")
    public Article get(String articleId) {
        Article article = articleRepository.findOne(articleId);
        article.setAnthor(userRepository.findOne(article.getUserid()));
        article.setAgo(DateUtils.fromToday(article.getDate()));
        return article;
    }

//    @Cacheable(value=ITBC.CACHE_NAME,key="'CACHE_ARTICLE_LIST'")
//    public Page<Article> findAll(Pageable pageable) {
//        Page<Article> articles = articleRepository.findAll(pageable);
//        for (Article article : articles){
//            User user = userRepository.findOne(article.getUserid());
//            article.setAnthor(user);
//            article.setAgo(DateUtils.fromToday(article.getDate()));
//            int length = article.getHtml().length();
//            if(length > 450){
//                length = 450;
//            }
//            article.setDesc(StringUtils.abbr(article.getHtml(),length));
//        }
//        return articles;
//    }

    public long count() {
        return articleRepository.count();
    }

    @Cacheable(value=ITBC.CACHE_NAME,key="'CACHE_ARTICLE_LIST'")
    public List<Article> findAll() {
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        List<Article> articles = articleRepository.findAll(sort);
        for (Article article : articles){
            User user = userRepository.findOne(article.getUserid());
            article.setAnthor(user);
            article.setAgo(DateUtils.fromToday(article.getDate()));
            int length = article.getHtml().length();
            if(length > 450){
                length = 450;
            }
            article.setDesc(StringUtils.abbr(article.getHtml(),length));
        }
        return articles;
    }
}
