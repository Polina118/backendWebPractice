package com.webPractice.webPractice.Appeals;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity(name = "answers")
@Getter
@Setter
@NoArgsConstructor
public class Answer {
    @Id
    @SequenceGenerator(
            name = "answers_sequence",
            sequenceName = "answers_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answers_sequence"
    )
    @Column(updatable = false)
    private Integer id;

    private Integer appealId;

    private String text;

    public Answer(Integer appealId, String text) {
        this.appealId = appealId;
        this.text = text;
    }
}
