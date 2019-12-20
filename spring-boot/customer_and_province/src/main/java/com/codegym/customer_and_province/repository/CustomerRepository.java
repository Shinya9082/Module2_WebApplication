package com.codegym.customer_and_province.repository;


import com.codegym.customer_and_province.model.Customer;
import com.codegym.customer_and_province.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
