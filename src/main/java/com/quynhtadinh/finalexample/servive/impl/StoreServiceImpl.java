//package com.quynhtadinh.finalexample.servive.impl;
//
//import com.quynhtadinh.finalexample.entity.Store;
//import com.quynhtadinh.finalexample.repository.StoreRepository;
//import com.quynhtadinh.finalexample.service.StoreService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class StoreServiceImpl implements StoreService {
//
//    private StoreRepository storeRepository;
//
//    @Override
//    public void save(Store user) {
//        storeRepository.save(user);
//    }
//
//    @Override
//    public Page<Store> findAll(Pageable pageable) {
//        return storeRepository.findAll(pageable);
//    }
//
//    @Override
//    public Store insert(Store user) {
//        return storeRepository.save(user);
//
//    }
//
//    @Override
//    public boolean delete(long id) {
//        // TODO Auto-generated method stub
//        Optional<Store> user = storeRepository.findById(id);
//        if (user.isPresent()) {
//            storeRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//
//
//    @Override
//    @Transactional
//    public Store update(Store store) {
//        // TODO Auto-generated method stub
//        Store updateUser = storeRepository.findById(store.getId()).orElse(null);
//        store.setName(store.getName());
//        store.setAddress(store.getAddress());
//        store.setPhone(store.getPhone());
//        store.setStatus(store.getStatus());
//
//        return storeRepository.save(store);
//    }
//
//
//    @Override
//    public List<Store> getAllStore() {
//        return storeRepository.findAll();
//    }
//
//    @Override
//    public Optional<Store> getStoreById(Long id) {
//        return storeRepository.findById(id);
//    }
//
//    @Override
//    public Store saveStore(Store user) {
//        return storeRepository.save(user);
//    }
//
//    @Override
//    public void deleteStoreById(Long id) {
//        storeRepository.deleteById(id);
//    }
//
//    @Override
//    public Page<Store> searchStore(Optional<String> keyword, Pageable pageable) {
//        String searchKeyword = keyword.orElse(""); // Nếu không có từ khóa, tìm kiếm với chuỗi rỗng
//        return storeRepository.findByNameContainingOrAddressContainingOrStatusContaining(searchKeyword, searchKeyword,searchKeyword, pageable);
//    }
//}
