package com.quynhtadinh.finalexample.servive.impl;

import com.quynhtadinh.finalexample.entity.Store;
import com.quynhtadinh.finalexample.repository.StoreRepository;
import com.quynhtadinh.finalexample.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {

    private StoreRepository storeRepository;

    @Override
    public Store getStoreById(Long id) {
        return null;
    }

    @Override
    public Store updateStore(Store store) {
        return null;
    }

    @Override
    public void deleteCustomersById(Long id) {

    }

    @Override
    public List<Store> getAllStore() {
        return Collections.emptyList();
    }

    @Override
    public Store saveStore(Store store) {
        return null;
    }
}
