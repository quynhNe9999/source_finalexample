package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Category;
import com.quynhtadinh.finalexample.entity.Suppliers;
import com.quynhtadinh.finalexample.repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuppliersService {

    @Autowired
    private SuppliersRepository suppliersRepository;

    public Suppliers saveSuppliers(Suppliers Suppliers) {
        return suppliersRepository.save(Suppliers);
    }

    public Suppliers updateSuppliers(Suppliers Suppliers) {
        return suppliersRepository.save(Suppliers);
    }

    public void deleteSuppliers(Long id) {
        suppliersRepository.deleteById(id);
    }

    public Optional<Suppliers> getSuppliersById(Long id) {
        return suppliersRepository.findById(id);
    }

    public Page<Suppliers> searchSuppliers(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return suppliersRepository.findByNameContaining(keyword, pageable);
    }
    public Page<Suppliers> findAll(Pageable pageable) {
        return suppliersRepository.findAll(pageable);
    }
}
