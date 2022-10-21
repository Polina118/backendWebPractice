package com.webPractice.webPractice.Appeals;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity(name = "appeals")
@Getter
@Setter
@NoArgsConstructor
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

    public Appeals(String text) {
        this.text = text;
    }

    public Appeals(String name, String text) {
        this.name = name;
        this.text = text;
        this.date_of_create = LocalDate.now();
    }
}