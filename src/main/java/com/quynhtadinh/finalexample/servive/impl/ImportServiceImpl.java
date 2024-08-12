package com.quynhtadinh.finalexample.servive.impl;

import com.quynhtadinh.finalexample.entity.Import;
import com.quynhtadinh.finalexample.repository.ImportRepository;
import com.quynhtadinh.finalexample.service.ImportService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class ImportServiceImpl implements ImportService {

    private ImportRepository importRepository;

    @Override
    public Import getImportById(Long id) {
        return null;
    }

    @Override
    public Import updateImport(Import imports) {
        return null;
    }

    @Override
    public void deleteImportById(Long id) {

    }

    @Override
    public List<Import> getAllImport() {
        return Collections.emptyList();
    }

    @Override
    public Import saveImport(Import imports) {
        return null;
    }
}
