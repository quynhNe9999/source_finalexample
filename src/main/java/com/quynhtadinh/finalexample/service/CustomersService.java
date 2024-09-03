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

    public void save(Customers customers) {
        customersRepository.save(customers);
    }


    public Page<Customers> findAll(Pageable pageable) {
        return customersRepository.findAll(pageable);
    }

    public Customers insert(Customers customers) {
        return customersRepository.save(customers);
    }

    public boolean delete(long id) {
        Optional<Customers> customers = customersRepository.findById(id);
        if (customers.isPresent()) {
            customersRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Customers update(Customers customers) {
        Customers updateCustomers = customersRepository.findById(customers.getCustomer_id()).orElse(null);
        if (updateCustomers != null) {
            updateCustomers.setName(customers.getName());
            updateCustomers.setAddress(customers.getAddress());
            updateCustomers.setEmail(customers.getEmail());
            updateCustomers.setPhone(customers.getPhone());
            // Thêm các phần khác của update nếu cần thiết
            return customersRepository.save(updateCustomers);
        }
        return null;
    }

    public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }

    public Optional<Customers> getCustomersById(Long id) {
        return customersRepository.findById(id);
    }

    public Customers saveCustomers(Customers customers) {
        return customersRepository.save(customers);
    }

    public void deleteCustomersById(Long id) {
        customersRepository.deleteById(id);
    }
    @Transactional
    public Customers updateCustomers(Customers newCustomers) {
        try {
            return customersRepository.findById(newCustomers.getCustomer_id())
                    .map(existingCustomers -> {
                        existingCustomers.setCustomer_id(newCustomers.getCustomer_id());
                        existingCustomers.setName(newCustomers.getName());
                        existingCustomers.setAddress(newCustomers.getAddress());
                        existingCustomers.setEmail(newCustomers.getEmail());
                        existingCustomers.setPhone(newCustomers.getPhone());

                        return customersRepository.save(existingCustomers);
                    })
                    .orElseGet(() -> {
                        newCustomers.setCustomer_id(newCustomers.getCustomer_id());
                        return customersRepository.save(newCustomers);
                    });
        } catch (Exception e) {
            // Ghi log lỗi để kiểm tra
            System.err.println("Lỗi khi cập nhật người dùng: " + e.getMessage());
            // Hoặc dùng logger
            // logger.error("Lỗi khi cập nhật người dùng", e);
            throw new RuntimeException("Có lỗi xảy ra khi cập nhật người dùng", e);
        }
    }


    public Page<Customers> searchCustomers(Optional<String> keyword, Pageable pageable) {
        String searchKeyword = keyword.orElse("");
        return customersRepository.findByNameContainingOrEmailContainingOrAddressContainingOrPhoneContaining(searchKeyword,searchKeyword,searchKeyword,searchKeyword, pageable);
    }
}
