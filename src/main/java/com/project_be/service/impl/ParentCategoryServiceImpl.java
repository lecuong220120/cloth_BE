package com.project_be.service.impl;

import com.project_be.dto.ParentCategoryDTO;
import com.project_be.model.Category;
import com.project_be.model.ParentCategory;
import com.project_be.repository.ParentCategoryRepository;
import com.project_be.service.CategoryService;
import com.project_be.service.ParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ParentCategoryServiceImpl implements ParentCategoryService {
    @Autowired
    ParentCategoryRepository parentCategoryRepository;
    @Autowired
    CategoryService categoryService;
    @Override
    public List<ParentCategory> findAll() {
        return null;
    }

    @Override
    public Optional<ParentCategory> findById(Long id) {
        return parentCategoryRepository.findById(id);
    }

    @Override
    public ParentCategory save(ParentCategory parentCategory) {
        return parentCategoryRepository.save(parentCategory);
    }

    @Override
    public List<ParentCategoryDTO> getParentCatgory() {
        List<ParentCategory> parentCategories = parentCategoryRepository.getAllParentCategory();
        List<ParentCategoryDTO> parentCategoryDTOS = new ArrayList<>();
        for (ParentCategory item : parentCategories) {
            ParentCategoryDTO parentCategoryDTO = new ParentCategoryDTO();
            parentCategoryDTO.setId(item.getId());
            parentCategoryDTO.setDelFlag(item.getDelFlag());
            parentCategoryDTO.setSubCategory(item.isSubCategory());
            parentCategoryDTO.setNameParentCategory(item.getNameParentCategory());
            if(item.isSubCategory()){
                List<Category> categories = categoryService.findAllById(item.getId());
                parentCategoryDTO.setCategoryList(categories);
            }else{
                parentCategoryDTO.setCategoryList(null);
            }
            parentCategoryDTOS.add(parentCategoryDTO);
        }
        return parentCategoryDTOS;
    }
}
