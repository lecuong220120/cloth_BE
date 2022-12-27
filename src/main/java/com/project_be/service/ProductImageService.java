package com.project_be.service;

import com.project_be.model.ProductImage;

import java.util.List;
import java.util.Optional;

public interface ProductImageService extends GeneralService<ProductImage>{
    @Override
    Optional<ProductImage> findById(Long id);

    @Override
    ProductImage save(ProductImage productImage);

    @Override
    List<ProductImage> findAll();
}
