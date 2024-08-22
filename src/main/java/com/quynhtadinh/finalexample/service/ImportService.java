//package com.quynhtadinh.finalexample.service;
//
//import com.quynhtadinh.finalexample.entity.Import;
//import com.quynhtadinh.finalexample.entity.Import;
//import com.quynhtadinh.finalexample.repository.ImportRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class ImportService {
//
//    @Autowired
//    private ImportRepository importRepository;
//
//    public Import saveImport(Import imports) {
//        return importRepository.save(imports);
//    }
//
//    public Import updateImport(Import imports) {
//        return importRepository.save(imports);
//    }
//
//    public void deleteImport(Long id) {
//        importRepository.deleteById(id);
//    }
//
//    public Optional<Import> getImportById(Long id) {
//        return importRepository.findById(id);
//    }
//
//    public Page<Import> searchImport(String keyword, int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return importRepository.findByImport_idContaining(keyword, pageable);
//    }
//}
