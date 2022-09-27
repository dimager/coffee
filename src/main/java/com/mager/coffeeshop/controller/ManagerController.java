package com.mager.coffeeshop.controller;

import com.mager.coffeeshop.entity.Product;
import com.mager.coffeeshop.service.ProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("products")
    public List<Product> allProd() {
        List<Product> all = productService.getAll();
        return all;
    }

    @PostMapping("/edit-product")
    public RedirectView editProduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile image) {
        productService.updateProduct(product, image);
        return new RedirectView("/");
    }

    @GetMapping("/products")
    public String getManagerPage() {
        return "manager.html";
    }

    @GetMapping("/edit-product/{id}")
    public String getEditProductPage(@PathVariable("id") String productId, Model model) {
        if (!ObjectId.isValid(productId)) {
            model.addAttribute("productIdIncorrect", true);
        } else {
            ObjectId product = new ObjectId(productId);
            if (productService.existById(product)) {
                model.addAttribute("product", productService.getById(product));
            } else {
                model.addAttribute("productNotFound", true);
            }
        }
        return "edit-product.html";
    }

    @GetMapping("/add-product")
    public String getAddProductPage(@ModelAttribute("product") Product product) {
        return "add-product.html";
    }

    @PostMapping("/delete-product/{id}")
    public RedirectView deleteProduct(@PathVariable("id") String productId) {
        productService.deleteProduct(new ObjectId(productId));
        return new RedirectView("/");
    }


    @PostMapping("/add-product")
    public RedirectView addProduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile image) throws IOException {
        Product newProduct = new Product();
        String encodedString;
        if (image.isEmpty()) {
            Path defaultImagePath = Paths.get("src/main/resources/static/img/default-image.jpg");
            encodedString = Base64.getEncoder().encodeToString(Files.readAllBytes(defaultImagePath));
        } else {
            encodedString = Base64.getEncoder().encodeToString(image.getBytes());
        }
        newProduct.setImageBase64(encodedString);
        newProduct.setName(product.getName());
        newProduct.setCost(product.getCost());
        newProduct.setDescription(product.getDescription());
        newProduct.setAvailable(product.isAvailable());
        productService.save(newProduct);
        return new RedirectView("/");
    }
}
