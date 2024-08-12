package com.quynhtadinh.finalexample.servive.impl;

import com.quynhtadinh.finalexample.entity.Customers;
import com.quynhtadinh.finalexample.repository.CustomersRepository;
import com.quynhtadinh.finalexample.service.CustomersService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class CustomersServiceImpl implements CustomersService {

    private CustomersRepository CustomersRepository;

    @Override
    public Customers getCustomersById(Long id) {
        return null;
    }

    @Override
    public Customers updateCustomers(Customers customers) {
        return null;
    }

    @Override
    public void deleteCustomersById(Long id) {

    }

    @Override
    public List<Customers> getAllCustomers() {
        return Collections.emptyList();
    }

    @Override
    public Customers saveCustomers(Customers customers) {
        return null;
    }
}
