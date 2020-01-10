package com.codegym.module2_test.service;


import com.codegym.module2_test.models.City;
import com.codegym.module2_test.models.Nation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CityService {
    Page<City> findAllByNation(Nation nation,Pageable pageable);
    Iterable<City> findAll();
    Page<City> findAll(Pageable pageable);
    void save(City city);
    City findById(Long id);
    void remove(Long id);
}
