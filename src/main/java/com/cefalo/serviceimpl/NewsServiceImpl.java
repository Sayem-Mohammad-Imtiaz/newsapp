package com.cefalo.serviceimpl;

import com.cefalo.dao.NewsDao;
import com.cefalo.model.News;
import com.cefalo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sayem on 11/18/2016.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public boolean addNews(News news) {
        return false;
    }

    @Override
    public List<News> listNews() {
        return null;
    }
}
