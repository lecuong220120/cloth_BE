package com.project_be.dto;

import com.project_be.model.Category;

import java.util.List;

public class ParentCategoryDTO {
    private Long id;
    private String nameParentCategory;
    private Boolean subCategory;
    private List<Category> categoryList;
    private Boolean delFlag;

    public ParentCategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameParentCategory() {
        return nameParentCategory;
    }

    public void setNameParentCategory(String nameParentCategory) {
        this.nameParentCategory = nameParentCategory;
    }

    public Boolean getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Boolean subCategory) {
        this.subCategory = subCategory;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public ParentCategoryDTO(Long id, String nameParentCategory, Boolean subCategory, List<Category> categoryList, Boolean delFlag) {
        this.id = id;
        this.nameParentCategory = nameParentCategory;
        this.subCategory = subCategory;
        this.categoryList = categoryList;
        this.delFlag = delFlag;
    }
}
