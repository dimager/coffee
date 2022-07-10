package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.entity.Product;
import com.mager.coffeeshop.repository.ProductRepository;
import com.mager.coffeeshop.service.ProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(ObjectId id) {
        return productRepository.findById(id).get();
    }

}
