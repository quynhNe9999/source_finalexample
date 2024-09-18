package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Role;
import com.quynhtadinh.finalexample.entity.Store;
import com.quynhtadinh.finalexample.repository.RoleRepository;
import com.quynhtadinh.finalexample.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    public List<Role> getAllActiveRole() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
