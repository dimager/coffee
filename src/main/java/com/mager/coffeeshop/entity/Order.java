package com.mager.coffeeshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "discount")
    private Integer discount = 0;

    @Column(name = "order_date_time", nullable = false)
    private Timestamp orderDateTime = Timestamp.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));

    @Column(name = "cost")
    private BigDecimal cost = BigDecimal.ONE;

    @Column(name = "order_status")
    private OrderStatus orderStatus = OrderStatus.NEW;


    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user.getUsername() +
                ", orderDateTime=" + orderDateTime +
                '}';
    }
}