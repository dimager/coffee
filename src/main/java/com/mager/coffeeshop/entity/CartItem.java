package com.mager.coffeeshop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cart")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public CartItem(String user_UUID) {
        this.user_UUID = user_UUID;
    }

    public CartItem(String user_UUID, String productId, Integer productCount) {
        this.user_UUID = user_UUID;
        this.productId = productId;
        this.productCount = productCount;
    }

    @Column(name = "UUID", length = 36)
    private String user_UUID;

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "product_count", nullable = false)
    private Integer productCount;

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user_UUID='" + user_UUID + '\'' +
                ", productId='" + productId + '\'' +
                ", productCount=" + productCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(id, cartItem.id) && Objects.equals(user_UUID, cartItem.user_UUID) && Objects.equals(productId, cartItem.productId) && Objects.equals(productCount, cartItem.productCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_UUID, productId, productCount);
    }
}
