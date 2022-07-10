package com.mager.coffeeshop.service;

import com.mager.coffeeshop.entity.Product;
import org.bson.types.ObjectId;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    List<Product> getAll();

    Product getById(ObjectId id);
}
