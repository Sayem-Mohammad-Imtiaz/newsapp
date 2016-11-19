package com.cefalo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * Created by sayem on 11/18/2016.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
        "title",
        "author",
        "publishDate",
        "body"
})
public class News {
    @XmlTransient
    @JsonIgnore
    private Integer id;
    @NotEmpty
    @Size(max = 255)
    private String title;
    @NotEmpty
    @Size(max = 100)
    private String author;
    @Size(max = 1000)
    private String body;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date publishDate=new Date();

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
