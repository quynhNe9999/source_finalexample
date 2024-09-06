package com.quynhtadinh.finalexample.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quynhtadinh.finalexample.entity.Customers;
import com.quynhtadinh.finalexample.repository.CustomersRepository;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    public void saveCustomers(Customers customers) {
        customersRepository.save(customers);
    }

    public List<Customers> getAllActiveCustomers() {
        return customersRepository.findAll();
    }

    public Optional<Customers> getCustomersById(Long id) {
        return customersRepository.findById(id);
    }
    public void deleteCustomers(Long id) {
        customersRepository.deleteById(id);
    }
}
