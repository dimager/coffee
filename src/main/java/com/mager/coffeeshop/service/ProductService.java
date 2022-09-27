package com.mager.coffeeshop.service;

import com.mager.coffeeshop.entity.Product;
import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    Product getById(ObjectId id);

    boolean existById(ObjectId id);

    Product save(Product product);

    void deleteProduct(ObjectId id);

    void updateProduct(Product product, MultipartFile image);
}
