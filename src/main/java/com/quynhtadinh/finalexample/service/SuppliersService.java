package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Suppliers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SuppliersService {

    Suppliers getSuppliersById(Long id);

    Suppliers updateSuppliers(Suppliers suppliers);

    void deleteSuppliersById(Long id);

    List<Suppliers> getAllSuppliers();

    Suppliers saveSuppliers(Suppliers suppliers);
}
