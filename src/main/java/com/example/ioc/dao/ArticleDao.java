package com.example.ioc.dao;

import com.example.ioc.vo.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleDao {
    private final List<Article> articles = new ArrayList<>();

    public List<Article> findAll() {
        return articles;
    }

    public void save(Article article) {
        articles.add(article);
    }
}
