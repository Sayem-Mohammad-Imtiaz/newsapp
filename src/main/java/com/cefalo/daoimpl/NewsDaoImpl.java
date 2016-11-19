package com.cefalo.daoimpl;

import com.cefalo.dao.NewsDao;
import com.cefalo.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sayem on 11/18/2016.
 */
@Repository
public class NewsDaoImpl implements NewsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean addNews(News news) {
        String sql = "INSERT INTO news(title, author, body) VALUES(?,?,?)";
        int id = jdbcTemplate.update(sql, news.getTitle(), news.getAuthor(), news.getBody());
        return (id != 0);
    }

    @Override
    public List<News> listNews() {
        return jdbcTemplate.query("SELECT * FROM news", new NewsRowMapper());
    }

    @Override
    public News getNewsById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM news where id=" + id, new NewsRowMapper());
    }

    class NewsRowMapper implements RowMapper<News> {
        @Override
        public News mapRow(ResultSet rs, int i) throws SQLException {
            News news = new News();
            news.setId(rs.getInt("id"));
            news.setTitle(rs.getString("title"));
            news.setAuthor(rs.getString("author"));
            news.setBody(rs.getString("body"));
            return news;
        }
    }


}
