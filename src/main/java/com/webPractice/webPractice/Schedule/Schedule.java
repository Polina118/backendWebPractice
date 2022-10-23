package com.webPractice.webPractice.Schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Schedule {

    @SequenceGenerator(
            name = "schedule_sequence",
            sequenceName = "schedule_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "schedule_sequence"
    )
    @Id
    private Integer id;

    private String groupName;

    private String day;

    private String teacher;

    @OneToMany
    @JoinColumn(name="sheduleId")
    private List<Subject> subjects;

    public Schedule(String groupName, String day, String teacher, List<Subject> subjects) {
        this.groupName = groupName;
        this.day = day;
        this.teacher = teacher;
        this.subjects = subjects;
    }
}
