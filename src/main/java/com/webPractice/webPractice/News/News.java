package com.webPractice.webPractice.News;

import javax.persistence.*;

@Entity
@Table
public class News {

    @SequenceGenerator(
            name = "news_sequence",
            sequenceName = "news_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "news_sequence"
    )
    @Id
    private Integer id;

    private String title;

    private String text;

    private String tag;

    public News(){}

    public News(String title, String text, String tag) {
        this.title = title;
        this.text = text;
        this.tag = tag;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
