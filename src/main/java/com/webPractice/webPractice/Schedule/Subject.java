package com.webPractice.webPractice.Schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Subject {
    @SequenceGenerator(
            name = "sub_sequence",
            sequenceName = "sub_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sub_sequence"
    )
    @Id
    private Integer id;

    private String name;

    private String time;

    private String place;

    private String teacher;

    public Subject(String name, String time, String place, String teacher) {
        this.name = name;
        this.time = time;
        this.place = place;
        this.teacher = teacher;
    }
}
