package com.webPractice.webPractice.News;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewsRepository extends JpaRepository<News, Integer> {
    Optional<News> findByTitle(String title);

}
