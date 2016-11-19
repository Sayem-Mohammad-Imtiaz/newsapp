package com.cefalo.dao;

import com.cefalo.model.News;

import java.util.List;

/**
 * Created by sayem on 11/18/2016.
 */
public interface NewsDao {
    boolean addNews(News news);

    List<News> listNews();

    News getNewsById(Integer id);
}
