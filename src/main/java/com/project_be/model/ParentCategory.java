package com.project_be.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parent_category")
public class ParentCategory extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sub_category")
    private boolean subCategory = false;
    @Column(name = "name_parent_category")
    private String nameParentCategory;
    public Long getId() {
        return id;
    }

    public ParentCategory(String nameParentCategory) {
        this.nameParentCategory = nameParentCategory;
    }

    public ParentCategory() {
    }

    public ParentCategory(Long id, boolean subCategory, String nameParentCategory) {
        this.id = id;
        this.subCategory = subCategory;
        this.nameParentCategory = nameParentCategory;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSubCategory() {
        return subCategory;
    }

    public void setSubCategory(boolean subCategory) {
        this.subCategory = subCategory;
    }

    public String getNameParentCategory() {
        return nameParentCategory;
    }

    public void setNameParentCategory(String nameParentCategory) {
        this.nameParentCategory = nameParentCategory;
    }
}
