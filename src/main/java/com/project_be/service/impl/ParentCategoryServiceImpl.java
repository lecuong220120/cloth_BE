package com.project_be.service.impl;

import com.project_be.model.ParentCategory;
import com.project_be.repository.ParentCategoryRepository;
import com.project_be.service.ParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ParentCategoryServiceImpl implements ParentCategoryService {
    @Autowired
    ParentCategoryRepository categoryRepository;
    @Override
    public List<ParentCategory> findAll() {
        return categoryRepository.getAllParentCategory();
    }

    @Override
    public Optional<ParentCategory> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public ParentCategory save(ParentCategory parentCategory) {
        return categoryRepository.save(parentCategory);
    }
}
