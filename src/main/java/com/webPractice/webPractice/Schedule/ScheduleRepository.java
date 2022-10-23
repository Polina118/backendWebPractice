package com.webPractice.webPractice.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findAllByGroupName(String groupName);


    List<Schedule> findAllByTeacher(String teacher);
}
