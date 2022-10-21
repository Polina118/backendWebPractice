package com.webPractice.webPractice.Appeals;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity(name = "appeals")
public class Appeals {

    @Id
    @SequenceGenerator(
            name = "appeals_sequence",
            sequenceName = "appeals_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "appeals_sequence"
    )
    @Column(updatable = false)
    private Integer id;

    @Column
    private String name; // name surname

    @Column
    private String text;

    @Column
    private LocalDate date_of_create;

    public Appeals(){}

    public Appeals(String name, String text) {
        this.name = name;
        this.text = text;
        this.date_of_create = LocalDate.now();
    }

    public Appeals(Integer id, String name, String text, LocalDate date_of_create) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.date_of_create = date_of_create;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate_of_create() {
        return date_of_create;
    }

    public void setDate_of_create(LocalDate date_of_create) {
        this.date_of_create = date_of_create;
    }
}