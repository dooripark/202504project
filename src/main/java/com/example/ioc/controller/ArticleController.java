package com.example.ioc.controller;

import com.example.ioc.service.ArticleService;
import com.example.ioc.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ResponseBody
    @GetMapping("/list")
    public List<Article> getArticleList() {
        return articleService.getAllArticles();
    }

    @ResponseBody
    @GetMapping(value = "/add", produces = "text/plain; charset=UTF-8")
    public String addArticle(@RequestParam String title, @RequestParam String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        articleService.addArticle(article);
        return "등록 완료";
    }
}
