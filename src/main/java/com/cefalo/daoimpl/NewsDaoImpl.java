package com.cefalo.daoimpl;

import com.cefalo.dao.NewsDao;
import com.cefalo.model.News;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sayem on 11/18/2016.
 */
@Repository
public class NewsDaoImpl implements NewsDao {
    @Override
    public boolean addNews(News news) {
        return false;
    }

    @Override
    public List<News> listNews() {
        return null;
    }
}
