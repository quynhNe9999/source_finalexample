package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Employees;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeesService {
    Employees getEmployeesById(Long id);

    Employees updateEmployees(Employees employees);

    void deleteEmployeesById(Long id);

    List<Employees> getAllEmployees();

    Employees saveEmployees(Employees employees);

    Page<Employees> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
