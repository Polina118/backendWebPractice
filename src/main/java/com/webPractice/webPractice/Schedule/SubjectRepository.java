package com.webPractice.webPractice.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findAllByTeacher(String teacher);
}
