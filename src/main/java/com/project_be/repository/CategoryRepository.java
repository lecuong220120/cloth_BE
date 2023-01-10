package com.project_be.repository;

import com.project_be.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByDelFlagFalse();

    Optional<Category> findByDelFlagFalse();

    @Query(value = "select * from category inner join  parent_category on category.parent_category_id = parent_category.id where parent_category.del_flag = 0", nativeQuery = true)
    List<Category> getAllCategoryFalse();

    @Query(value = "select * from category where parent_category_id = :id", nativeQuery = true)
    List<Category> findAllById(@Param("id") Long id);
}
