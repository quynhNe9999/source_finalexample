package com.quynhtadinh.finalexample.service;

import java.util.List;
import java.util.Optional;

import com.quynhtadinh.finalexample.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quynhtadinh.finalexample.entity.Store;
import com.quynhtadinh.finalexample.repository.StoreRepository;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public void saveStore(Store store) {
        storeRepository.save(store);
    }

    public List<Store> getAllActiveStore() {
        return storeRepository.findAll();
    }

    public Optional<Store> getStoreById(Long id) {
        return storeRepository.findById(id);
    }
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
}
