package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Customers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomersService {
    Customers getCustomersById(Long id);

    Customers updateCustomers(Customers customers);

    void deleteCustomersById(Long id);

    List<Customers> getAllCustomers();

    Customers saveCustomers(Customers customers);

    Optional<Customers> getUserById(Long id);

    Customers saveUser(Customers customers);

    void deleteUserById(Long id);

    Customers updateCustomers(Long id, Customers newCustomers);
}
