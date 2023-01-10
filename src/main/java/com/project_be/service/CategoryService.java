package com.project_be.service;

import com.project_be.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryService extends GeneralService<Category>{
    @Override
    List<Category> findAll();

    @Override
    Optional<Category> findById(Long id);

    @Override
    Category save(Category category);

    public List<Category> findAllById(Long id);
}
