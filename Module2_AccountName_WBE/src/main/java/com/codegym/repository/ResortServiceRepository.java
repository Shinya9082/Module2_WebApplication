package com.codegym.repository;

import com.codegym.model.ResortService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResortServiceRepository extends PagingAndSortingRepository<ResortService,Long> {
}
