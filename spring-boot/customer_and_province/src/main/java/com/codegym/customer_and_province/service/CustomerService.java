package com.codegym.customer_and_province.service;

import com.codegym.customer_and_province.model.Customer;
import com.codegym.customer_and_province.model.Province;


import java.util.Optional;

public interface CustomerService {
    Iterable<Customer> findAllByProvince(Province province);
    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}

