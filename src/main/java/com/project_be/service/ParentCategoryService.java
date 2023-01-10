package com.project_be.service;

import com.project_be.dto.ParentCategoryDTO;
import com.project_be.model.ParentCategory;

import java.util.List;

public interface ParentCategoryService extends GeneralService<ParentCategory>{
    List<ParentCategoryDTO> getParentCatgory();
}
