package com.codegym.customer_and_province.service;

import com.codegym.customer_and_province.model.Province;

import java.util.Optional;

public interface ProvinceService {
    Iterable<Province> findAll();

    Optional<Province> findById(Long id);

    void save(Province province);

    void remove(Long id);
}
