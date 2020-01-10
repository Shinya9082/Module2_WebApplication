package com.codegym.module2_test.service.impl;


import com.codegym.module2_test.models.City;
import com.codegym.module2_test.models.Nation;
import com.codegym.module2_test.repository.CityRepository;
import com.codegym.module2_test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public Page<City> findAllByNation(Nation nation,Pageable pageable) {
        return cityRepository.findAllByNation(nation,pageable);
    }

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }

}
