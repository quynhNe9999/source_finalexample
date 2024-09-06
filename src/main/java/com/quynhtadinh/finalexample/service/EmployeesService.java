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


    public void save(Employees category) {
        employeesRepository.save(category);
    }


    public Page<Employees> findAll(Pageable pageable) {
        return employeesRepository.findAll(pageable);
    }

    public Employees insert(Employees Category) {
        return employeesRepository.save(Category);
    }

    public boolean delete(long id) {
        Optional<Employees> Category = employeesRepository.findById(id);
        if (Category.isPresent()) {
            employeesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Employees update(Employees employees) {
        Employees updateEmployees = employeesRepository.findById(employees.getId()).orElse(null);
        if (updateEmployees != null) {
            updateEmployees.setName(employees.getName());
            updateEmployees.setAddress(employees.getAddress());
            updateEmployees.setEmail(employees.getEmail());
            updateEmployees.setPhone(employees.getPhone());
            updateEmployees.setDateOfBirth(employees.getDateOfBirth());
            updateEmployees.setStore(employees.getStore());
            updateEmployees.setPosition(employees.getPosition());
            return employeesRepository.save(updateEmployees);
        }
        return null;
    }

    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    public Optional<Employees> getEmployeesById(Long id) {
        return employeesRepository.findById(id);
    }

    public Employees saveEmployees(Employees employees) {
        return employeesRepository.save(employees);
    }

    public void deleteEmployeesById(Long id) {
        employeesRepository.deleteById(id);
    }
    @Transactional
    public Employees updateEmployees(Employees newEmployees) {
        try {
            return employeesRepository.findById(newEmployees.getId())
                    .map(existingEmployees -> {
                        existingEmployees.setEmployee_id(newEmployees.getId());
                        existingEmployees.setName(newEmployees.getName());
                        existingEmployees.setAddress(newEmployees.getAddress());
                        existingEmployees.setEmail(newEmployees.getEmail());
                        existingEmployees.setPhone(newEmployees.getPhone());
                        existingEmployees.setDateOfBirth(newEmployees.getDateOfBirth());
                        existingEmployees.setStore(newEmployees.getStore());
                        existingEmployees.setPosition(newEmployees.getPosition());
                        return employeesRepository.save(existingEmployees);
                    })
                    .orElseGet(() -> {
                        newEmployees.setEmployee_id(newEmployees.getId());
                        return employeesRepository.save(newEmployees);
                    });
        } catch (Exception e) {
            // Ghi log lỗi để kiểm tra
            System.err.println("Lỗi khi cập nhật người dùng: " + e.getMessage());
            // Hoặc dùng logger
            // logger.error("Lỗi khi cập nhật người dùng", e);
            throw new RuntimeException("Có lỗi xảy ra khi cập nhật người dùng", e);
        }
    }


    public Page<Employees> searchEmployees(Optional<String> keyword, Pageable pageable) {
        String searchKeyword = keyword.orElse("");
        return employeesRepository.findByNameContainingOrEmailContaining(searchKeyword, searchKeyword, pageable);
    }
}
