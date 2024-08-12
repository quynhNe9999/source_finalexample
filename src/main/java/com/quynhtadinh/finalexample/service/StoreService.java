package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreService {

    Store getStoreById(Long id);

    Store updateStore(Store store);

    void deleteCustomersById(Long id);

    List<Store> getAllStore();

    Store saveStore(Store store);
}
