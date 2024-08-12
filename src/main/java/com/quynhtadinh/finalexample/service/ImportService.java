package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Import;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImportService {
    Import getImportById(Long id);

    Import updateImport(Import imports);

    void deleteImportById(Long id);

    List<Import> getAllImport();

    Import saveImport(Import imports);
}
