package com.cefalo.serviceimpl;

import com.cefalo.dao.NewsDao;
import com.cefalo.model.News;
import com.cefalo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sayem on 11/18/2016.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    @Transactional
    public boolean addNews(News news) {
        return newsDao.addNews(news);
    }

    @Override
    @Transactional(readOnly = true)
    public List<News> listNews() {
        return newsDao.listNews();
    }

    @Override
    public News getNewsById(Integer id) {
        return newsDao.getNewsById(id);
    }
}
