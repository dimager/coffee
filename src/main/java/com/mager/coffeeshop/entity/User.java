package com.mager.coffeeshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findByUsernameEquals", query = "select u from User u where u.username = :username")
})
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "enabled", nullable = false)
    private Integer enabled;

    @Column(name = "discount")
    private Integer discount = 0;

    @OneToMany(mappedBy = "user")
    private Set<Cart> carts = new LinkedHashSet<>();
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new TreeSet<>(Comparator.comparing(Order::getOrderDateTime));

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", discount=" + discount +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public User(String username) {
        this.username = username;
    }

}