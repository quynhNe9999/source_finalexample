package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Product;
import com.quynhtadinh.finalexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllActiveProduct() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}

