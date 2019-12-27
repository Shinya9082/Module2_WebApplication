package com.codegym.service.impl;

import com.codegym.model.ResortService;
import com.codegym.repository.ResortServiceRepository;
import com.codegym.service.ResortService_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResortService_ServiceImpl implements ResortService_Service {
    @Autowired
    ResortServiceRepository serviceRepository;
    @Override
    public Iterable<ResortService> getAllResortService() {
        return serviceRepository.findAll();
    }

    @Override
    public ResortService getResortService(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ResortService resortService) {
        serviceRepository.save(resortService);
    }

    @Override
    public void delete(Long id) {
        serviceRepository.deleteById(id);
    }
}
