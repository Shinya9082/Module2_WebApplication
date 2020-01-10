package com.codegym.module2_test.repository;


import com.codegym.module2_test.models.City;
import com.codegym.module2_test.models.Nation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City,Long> {
    Page<City> findAllByNation(Nation nation,Pageable pageable);
}
