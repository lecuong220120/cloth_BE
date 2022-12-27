package com.project_be.repository;

import com.project_be.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByDelFlagFalse();
    Optional<Category> findByDelFlagFalse();
}
