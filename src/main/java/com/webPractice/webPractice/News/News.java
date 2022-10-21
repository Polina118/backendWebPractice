package com.webPractice.webPractice.News;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
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

    private LocalDate date_of_create;

    public News(String title, String text, String tag) {
        this.title = title;
        this.text = text;
        this.tag = tag;
        this.date_of_create = LocalDate.now();
    }
}
