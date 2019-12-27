package com.codegym.service;

import com.codegym.model.ResortService;

public interface ResortService_Service {
    Iterable<ResortService> getAllResortService();
    ResortService getResortService(Long id);
    void save(ResortService resortService);
    void delete(Long id);
}
