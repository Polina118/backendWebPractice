package com.webPractice.webPractice.Appeals;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppealsRepository extends JpaRepository<Appeals, Integer> {
    Optional<Appeals> findByText(String text);

}