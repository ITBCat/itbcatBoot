package cn.itbcat.boot.service.front;

import cn.itbcat.boot.entity.front.Article;
import cn.itbcat.boot.entity.admin.User;
import cn.itbcat.boot.repository.front.ArticleRepository;
import cn.itbcat.boot.utils.ITBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 860117030 on 2017/10/14.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public void save(Article article) {
        User user = ITBC.getCurrUser();
        article.setId(ITBC.getId());
        article.setUserid(user.getUserId());
        article.setDate(new Date());
        articleRepository.save(article);
    }

    public Article get(String articleId) {
        return articleRepository.findOne(articleId);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}