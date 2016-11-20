package com.cefalo;

import com.cefalo.model.News;
import com.cefalo.service.NewsService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import util.CommonUtils;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by User on 11/19/2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NewsServiceTest extends NewsAppTests {
    @Autowired
    private NewsService newsService;

    @Test
    public void test01_addNews() {
        News news = new News();
        news.setTitle("Test article 1");
        news.setAuthor("Test author 1");
        news.setBody("Test body 1");
        news.setPublishDate(CommonUtils.parseStringFromDate(new Date(), null));
        assertThat(newsService.addNews(news)).isTrue();
    }

    @Test
    public void test02_listAllNews() {
        List<News> newsList = newsService.listNews();
        assertThat(newsList).isNotEmpty();
    }

    @Test
    public void test03_getNewsById() {
        List<News> newsList = newsService.listNews();
        assertThat(newsList).isNotEmpty();
        News news = newsService.getNewsById(newsList.get(0).getId());
        assertThat(news).isNotNull();
    }

}
