package com.example.ioc.service;

import com.example.ioc.dao.ArticleDao;
import com.example.ioc.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public List<Article> getAllArticles() {
        return articleDao.findAll();
    }

    public void addArticle(Article article) {
        articleDao.save(article);
    }
}
