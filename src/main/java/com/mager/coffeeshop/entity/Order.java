package com.mager.coffeeshop.entity;

import com.mager.coffeeshop.dto.CustomerOrderInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "discount", columnDefinition = "0")
    private Integer discount;

    @Column(name = "order_date_time", nullable = false, columnDefinition = "NOW()")
    private Timestamp orderDateTime;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "order_status", columnDefinition = "1")
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location = new Location();

    @ManyToOne
    @JoinColumn(name = "user_uuid")
    private User user;
/*
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "orders", cascade = CascadeType.ALL)
    private OrderUserinfo orderUserinfo;*/

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userinfo_id")
    private OrderUserinfo orderUserinfo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(discount, order.discount) && Objects.equals(orderDateTime, order.orderDateTime) && Objects.equals(cost, order.cost) && orderStatus == order.orderStatus && Objects.equals(orderDetails, order.orderDetails) && Objects.equals(location, order.location) && Objects.equals(user, order.user);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", discount=" + discount +
                ", orderDateTime=" + orderDateTime +
                ", cost=" + cost +
                ", orderStatus=" + orderStatus +
                ", orderDetails=" + orderDetails +
                ", location=" + location +
                ", user=" + user +
                ", orderUserinfo=" + orderUserinfo +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discount, orderDateTime, cost, orderStatus, orderDetails);
    }
}