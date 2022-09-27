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
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "order_detail")
@Getter
@Setter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public OrderDetail(String productId, Integer productCount, BigDecimal productCost, String productName) {
        this.productId = productId;
        this.productName = productName;
        this.productCount = productCount;
        this.productCost = productCost;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_count", nullable = false)
    private Integer productCount;

    @Column(name = "product_cost", nullable = false)
    private BigDecimal productCost;

    public OrderDetail() {

    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", productCount=" + productCount +
                ", productCost=" + productCost +
                '}';
    }
}