package com.project_be.service;

import com.project_be.model.Discount;

import java.util.List;
import java.util.Optional;

public interface DiscountService extends GeneralService<Discount>{
    @Override
    List<Discount> findAll();

    @Override
    Optional<Discount> findById(Long id);

    @Override
    Discount save(Discount discount);
}
