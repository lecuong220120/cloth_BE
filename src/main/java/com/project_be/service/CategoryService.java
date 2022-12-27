package com.project_be.service;

import com.project_be.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService extends GeneralService<Category>{
    @Override
    List<Category> findAll();

    @Override
    Optional<Category> findById(Long id);

    @Override
    Category save(Category category);
}
