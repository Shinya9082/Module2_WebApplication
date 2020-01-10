package com.codegym.module2_test.repository;


import com.codegym.module2_test.models.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationRepository extends PagingAndSortingRepository<Nation,Long> {
    Nation findByName(String name);
}
