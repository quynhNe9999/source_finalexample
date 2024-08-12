package com.quynhtadinh.finalexample.servive.impl;

import com.quynhtadinh.finalexample.entity.Employees;
import com.quynhtadinh.finalexample.repository.EmployeesRepository;
import com.quynhtadinh.finalexample.service.EmployeesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    private EmployeesRepository employeesRepository;

    @Override
    public Employees getEmployeesById(Long id) {
        Optional<Employees> optional = employeesRepository.findById(id);
        Employees employees = null;
        if (optional.isPresent()) {
            employees = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employees;    }

    @Override
    public Employees updateEmployees(Employees employees) {
        return null;
    }

    @Override
    public void deleteEmployeesById(Long id) {
        this.employeesRepository.deleteById(id);
    }

    @Override
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();    }

    @Override
    public Employees saveEmployees(Employees employees) {

        return this.employeesRepository.save(employees);}

    @Override
    public Page<Employees> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeesRepository.findAll(pageable);    }
}
