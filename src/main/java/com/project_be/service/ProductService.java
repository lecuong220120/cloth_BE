package com.project_be.service;

import com.project_be.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService extends GeneralService<Product>{
    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long id);

    @Override
    Product save(Product product);
}
