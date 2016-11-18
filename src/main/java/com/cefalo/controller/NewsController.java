package com.cefalo.controller;

import com.cefalo.model.News;
import com.cefalo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sayem on 11/18/2016.
 */
@Controller
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping
    public String addNews(@ModelAttribute News news, Model model)
    {
        newsService.addNews(news);
        return "news/home";
    }

    @GetMapping
    public String getNews(Model model)
    {
        newsService.listNews();
        return "news/home";
    }
}
