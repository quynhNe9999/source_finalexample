package com.quynhtadinh.finalexample.servive.impl;

import com.quynhtadinh.finalexample.entity.Suppliers;
import com.quynhtadinh.finalexample.repository.SupppliersRepository;
import com.quynhtadinh.finalexample.service.SuppliersService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class SuppliersServiceImpl implements SuppliersService {

    private SupppliersRepository supppliersRepository;

    @Override
    public Suppliers getSuppliersById(Long id) {
        return null;
    }

    @Override
    public Suppliers updateSuppliers(Suppliers suppliers) {
        return null;
    }

    @Override
    public void deleteSuppliersById(Long id) {

    }

    @Override
    public List<Suppliers> getAllSuppliers() {
        return Collections.emptyList();
    }

    @Override
    public Suppliers saveSuppliers(Suppliers suppliers) {
        return null;
    }
}
