package com.mager.coffeeshop.service.impl;

import com.mager.coffeeshop.entity.CartItem;
import com.mager.coffeeshop.entity.Product;
import com.mager.coffeeshop.repository.CartRepository;
import com.mager.coffeeshop.service.CartService;
import com.mager.coffeeshop.service.ProductService;
import com.mager.coffeeshop.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final ProductService productService;

    private final UserService userService;

    public CartServiceImpl(CartRepository cartRepository, ProductService productService, UserService userService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.userService = userService;
    }


    @Override
    public void cleanUserCart() {
        String customerUUID = userService.getCustomerUUID();
        cartRepository.deleteAll(this.getUserCart(customerUUID));
    }

    @Override
    public Map<Product, Integer> getUserProductCart() {
        String customerUUID = userService.getCustomerUUID();
        Map<Product, Integer> collect = getUserCart(customerUUID)
                .stream()
                .collect(Collectors.toMap(
                        cartItem -> productService.getById(new ObjectId(cartItem.getProductId())),
                        CartItem::getProductCount
                ));
        return collect;
    }

    @Override
    public List<CartItem> getUserCart(String UUID) {
        CartItem cartItem = new CartItem(UUID);
        List<CartItem> userCartItems = cartRepository.findAll(Example.of(cartItem));
        return userCartItems;
    }

    @Override
    public void addToCart(Product product) {
        if (productService.existById(product.getId())) {
            Product productById = productService.getById(product.getId());
            if (productById.isAvailable() && !productById.isDeleted()) {
                Example<CartItem> cartItemExample = getCartItemExampleWithProduct(product);
                Optional<CartItem> cartItem = cartRepository.findOne(cartItemExample);
                this.addItemToUserCart(product, cartItem);
            }
        }
    }

    private Example<CartItem> getCartItemExampleWithProduct(Product product) {
        CartItem item = new CartItem(userService.getCustomerUUID());
        item.setProductId(product.getId().toString());
        return Example.of(item);

    }

    private void addItemToUserCart(Product product, Optional<CartItem> cartItem) {
        if (cartItem.isPresent()) {
            Integer productCount = cartItem.get().getProductCount();
            cartItem.get().setProductCount(++productCount);
            cartRepository.save(cartItem.get());
        } else {
            CartItem newCartItem = new CartItem(userService.getCustomerUUID(), product.getId().toString(), 1);
            cartRepository.save(newCartItem);
        }
    }

    @Override
    public void deleteFromCart(Product product) {
        List<CartItem> userCartItem = getUserCart(userService.getCustomerUUID());
        for (CartItem cartItem : userCartItem) {
            if (cartItem.getProductId().equals(product.getId().toString())) {
                Integer productCount = cartItem.getProductCount();
                if (productCount > 1) {
                    cartItem.setProductCount(--productCount);
                    cartRepository.save(cartItem);
                } else {
                    cartRepository.delete(cartItem);
                }
            }
        }
    }
}
