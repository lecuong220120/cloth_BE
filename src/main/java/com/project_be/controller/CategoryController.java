package com.project_be.controller;

import com.project_be.model.Category;
import com.project_be.model.ParentCategory;
import com.project_be.service.CategoryService;
import com.project_be.service.ParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ParentCategoryService parentCategoryService;
    @GetMapping
    public ResponseEntity<?> getCategories(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @GetMapping("id")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    @Transactional
    public ResponseEntity<?> save(@RequestBody Category category) {
        ParentCategory parentCategory = parentCategoryService.findById(category.getParentCategory().getId()).orElseThrow(()-> new RuntimeException("parent category not found"));
        category.setParentCategory(parentCategory);
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.OK);
    }
}
