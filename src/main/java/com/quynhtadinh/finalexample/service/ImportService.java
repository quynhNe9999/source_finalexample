package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Import;
import com.quynhtadinh.finalexample.repository.ImportRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImportService {

    @Autowired
    private ImportRepository importRepository;

    public void saveImport(Import employees) {
        importRepository.save(employees);
    }

    public List<Import> getAllActiveImport() {
        return importRepository.findAll();
    }

    public Optional<Import> getImportById(Long id) {
        return importRepository.findById(id);
    }
    public void deleteImport(Long id) {
        importRepository.deleteById(id);
    }
}
