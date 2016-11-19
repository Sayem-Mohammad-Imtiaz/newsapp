package com.cefalo.controller;

import com.cefalo.model.News;
import com.cefalo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by sayem on 11/18/2016.
 */
@Controller
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @ModelAttribute("news")
    News getNews() {
        return new News();
    }

    @PostMapping("addStory")
    public String addNews(@ModelAttribute("news") @Valid News news, BindingResult bindingResult,
                          Model model) {
        try {
            if (bindingResult.hasErrors()) {
                throw new RuntimeException("Form has errors");
            }
            if (!newsService.addNews(news))
                throw new RuntimeException("Story creation failed. Please try again.");
            model.addAttribute("successMessage", "Story created successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            model.addAttribute("errorMessage", ex.getMessage());
        }
        model.addAttribute("index", 2);
        return "news/add_story";
    }

    @GetMapping("addStory")
    public String getAddStory(@ModelAttribute("news") News news, Model model) {
        model.addAttribute("index", 2);
        return "news/add_story";
    }

    @GetMapping
    public String getNews(Model model) {
        newsService.listNews();

        model.addAttribute("index", 1);
        return "news/home";
    }
}
