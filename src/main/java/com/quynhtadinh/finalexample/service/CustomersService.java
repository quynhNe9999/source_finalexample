package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Category;
import com.quynhtadinh.finalexample.entity.Customers;
import com.quynhtadinh.finalexample.repository.CategoryRepository;
import com.quynhtadinh.finalexample.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    public Customers saveCustomers(Customers category) {
        return customersRepository.save(category);
    }

    public Customers updateCustomers(Customers category) {
        return customersRepository.save(category);
    }

    public void deleteCustomers(Long id) {
        customersRepository.deleteById(id);
    }

    public Optional<Customers> getCustomersById(Long id) {
        return customersRepository.findById(id);
    }

    public Page<Customers> searchCustomers(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return customersRepository.findByNameContaining(keyword, pageable);
    }
}
