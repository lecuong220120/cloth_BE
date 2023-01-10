package com.project_be.repository;

import com.project_be.model.ParentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentCategoryRepository extends JpaRepository<ParentCategory, Long> {
    @Query(value = "select * from parent_category where del_flag = 0 ", nativeQuery = true)
    List<ParentCategory> getAllParentCategory();
}
