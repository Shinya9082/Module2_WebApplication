package com.codegym.module2_test.service;


import com.codegym.module2_test.models.Nation;

public interface NationService {
    Iterable<Nation> findAll();
    Nation findByName(String name);
}
