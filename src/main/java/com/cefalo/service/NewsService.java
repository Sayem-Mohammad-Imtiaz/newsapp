package com.cefalo.service;

import com.cefalo.model.News;

import java.util.List;

/**
 * Created by sayem on 11/18/2016.
 */
public interface NewsService {
    boolean addNews(News news);

    List<News> listNews();
}
