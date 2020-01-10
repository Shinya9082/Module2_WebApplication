package com.codegym.module2_test.service.impl;


import com.codegym.module2_test.models.Nation;

import com.codegym.module2_test.repository.NationRepository;
import com.codegym.module2_test.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NationServiceImpl implements NationService {
    @Autowired
    NationRepository nationRepository;
    @Override
    public Iterable<Nation> findAll() {
        return nationRepository.findAll();
    }

    @Override
    public Nation findByName(String name) {
        return nationRepository.findByName(name);
    }
}
