package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.entity.Product;
import com.mager.coffeeshop.repository.ProductRepository;
import com.mager.coffeeshop.service.ProductService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(ObjectId id) {
        return productRepository.findById(id).get();
    }

    @Override
    public boolean existById(ObjectId id) {
        return productRepository.existsById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(ObjectId id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }

    @Override
    public void updateProduct(Product product, MultipartFile image) {
        if (this.existById(product.getId())) {
            Product productFromDB = this.getById(product.getId());
            if (!image.isEmpty()) {
                try {
                    productFromDB.setImageBase64(Base64.getEncoder().encodeToString(image.getBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            productFromDB.setName(product.getName());
            productFromDB.setCost(product.getCost());
            productFromDB.setDescription(product.getDescription());
            productFromDB.setAvailable(product.isAvailable());
            productFromDB.setDeleted(product.isDeleted());
            this.save(productFromDB);
        }
    }
}
