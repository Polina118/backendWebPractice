package com.webPractice.webPractice.Appeals;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    Answer findByAppealId(Integer appealId);
}
