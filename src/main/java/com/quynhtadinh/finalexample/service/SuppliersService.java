package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Category;
import com.quynhtadinh.finalexample.entity.Store;
import com.quynhtadinh.finalexample.entity.Suppliers;
import com.quynhtadinh.finalexample.repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuppliersService {

    @Autowired
    private SuppliersRepository suppliersRepository;

    public void saveSuppliers(Suppliers suppliers) {
        suppliersRepository.save(suppliers);
    }

    public List<Suppliers> getAllActiveSuppliers() {
        return suppliersRepository.findAll();
    }

    public Optional<Suppliers> getSuppliersById(Long id) {
        return suppliersRepository.findById(id);
    }
    public void deleteSuppliers(Long id) {
        suppliersRepository.deleteById(id);
    }}
