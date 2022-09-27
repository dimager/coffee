package com.mager.coffeeshop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "order_userinfo")
@Getter
@Setter
@NoArgsConstructor
public class OrderUserinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
/*

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Order orders;
*/

    @Column(name = "phone", length = 45)
    private String phone;

    @Column(name = "name", length = 45)
    private String name;

    @OneToMany(mappedBy = "orderUserinfo")
    private Set<Order> orders = new LinkedHashSet<>();

    public OrderUserinfo(String name, String phone) {
        this.phone = phone;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderUserinfo that = (OrderUserinfo) o;
        return Objects.equals(id, that.id) && Objects.equals(orders, that.orders) && Objects.equals(phone, that.phone) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orders, phone, name);
    }

    @Override
    public String toString() {
        return "OrderUserinfo{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}