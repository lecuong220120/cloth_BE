package com.project_be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parent_category_id", nullable = false)
    private ParentCategory parentCategory;
    public String getImage() {
        return image;
    }

    public Category(Long id, String categoryName, String description, String image, ParentCategory parentCategory) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.image = image;
        this.parentCategory = parentCategory;
    }

    public Category(String categoryName, String description, ParentCategory parentCategory) {
        this.categoryName = categoryName;
        this.description = description;
        this.parentCategory = parentCategory;
    }

    public ParentCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(ParentCategory parentCategory) {
        this.parentCategory = parentCategory;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category() {
    }

    public Category(Long id, String categoryName, String description) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
    }
}
