package com.mager.coffeeshop.scheduler;

import com.mager.coffeeshop.entity.CartItem;
import com.mager.coffeeshop.entity.User;
import com.mager.coffeeshop.repository.CartRepository;
import com.mager.coffeeshop.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.session.data.mongo.MongoIndexedSessionRepository;
import org.springframework.session.data.mongo.MongoSession;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class GuestCartCleaner {
    private static final Logger logger = LogManager.getLogger("OrderService");
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    MongoIndexedSessionRepository mongoIndexedSessionRepository;

    @Scheduled(fixedDelay = 20000)
    public void cleanGuestCart() {
        mongoIndexedSessionRepository.setCollectionName("mdbsessions");
        List<String> usersUUID = userRepository.findAll().stream().map(User::getUUID).collect(Collectors.toList());
        List<String> cartUUID = cartRepository.findAll().stream().map(CartItem::getUser_UUID).distinct().collect(Collectors.toList());
        cartUUID.removeAll(usersUUID);

        for (String s : cartUUID) {
            MongoSession session = mongoIndexedSessionRepository.findById(s);
            if (Objects.isNull(session)) {
                CartItem cartItem = new CartItem();
                cartItem.setUser_UUID(s);
                Example example = Example.of(cartItem);
                List all = cartRepository.findAll(example);
                cartRepository.deleteAll(all);
            }
        }
    }
}
