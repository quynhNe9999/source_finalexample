package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Employees;
import com.quynhtadinh.finalexample.entity.Product;
import com.quynhtadinh.finalexample.repository.EmployeesRepository;
import com.quynhtadinh.finalexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public Employees saveEmployees(Employees product) {
        return employeesRepository.save(product);
    }

    public Employees updateEmployees(Employees product) {
        return employeesRepository.save(product);
    }

    public void deleteEmployees(Long id) {
        employeesRepository.deleteById(id);
    }

    public Optional<Employees> getEmployeesById(Long id) {
        return employeesRepository.findById(id);
    }

    public Page<Employees> searchEmployees(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeesRepository.findByNameContaining(keyword, pageable);
    }
}
