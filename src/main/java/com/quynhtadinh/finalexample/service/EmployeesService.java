package com.quynhtadinh.finalexample.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quynhtadinh.finalexample.entity.Employees;
import com.quynhtadinh.finalexample.repository.EmployeesRepository;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public void saveEmployees(Employees employees) {
        employeesRepository.save(employees);
    }

    public List<Employees> getAllActiveEmployees() {
        return employeesRepository.findAll();
    }

    public Optional<Employees> getEmployeesById(Long id) {
        return employeesRepository.findById(id);
    }
    public void deleteEmployees(Long id) {
        employeesRepository.deleteById(id);
    }
}
