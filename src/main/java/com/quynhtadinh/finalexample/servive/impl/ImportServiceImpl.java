//package com.quynhtadinh.finalexample.servive.impl;
//
//import com.quynhtadinh.finalexample.entity.Import;
//import com.quynhtadinh.finalexample.repository.ImportRepository;
//import com.quynhtadinh.finalexample.service.ImportService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class ImportServiceImpl implements ImportService {
//
//    private ImportRepository importRepository;
//
//    @Override
//    public Import getImportById(Long id) {
//        return null;
//    }
//
//    @Override
//    public Import updateImport(Import imports) {
//        return null;
//    }
//
//    @Override
//    public void deleteImportById(Long id) {
//
//    }
//
//    @Override
//    public Page<Import> getAllImport(Pageable pageable) {
//        return importRepository.findAll(pageable);
//
//    }
//
//    @Override
//    public Import saveImport(Import imports) {
//        return null;
//    }
//
//    @Override
//    public Optional<Import> getUserById(Long id) {
//        return Optional.empty();
//    }
//
////    @Override
////    public Page<Import> searchKho(Optional<String> keyword, Pageable pageable) {
//////        String searchKeyword = keyword.orElse(""); // Nếu không có từ khóa, tìm kiếm với chuỗi rỗng
////        return importRepository.findByImport_idContaining(keyword, pageable);    }
//}
