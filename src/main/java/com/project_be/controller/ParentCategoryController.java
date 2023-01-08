package com.project_be.controller;

import com.project_be.model.ParentCategory;
import com.project_be.service.ParentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parentcategory")
public class ParentCategoryController {
    @Autowired
    ParentCategoryService parentCategoryService;
    @GetMapping
    public ResponseEntity<?> getAllParentCategory(){

        return new ResponseEntity<>(parentCategoryService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody ParentCategory parentCategory){
        return new ResponseEntity<>(parentCategoryService.save(parentCategory), HttpStatus.OK);
    }
}
