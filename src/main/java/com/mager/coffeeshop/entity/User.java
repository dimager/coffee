package com.mager.coffeeshop.entity;

import com.mager.coffeeshop.security.Roles;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findByUUIDEquals", query = "select u from User u where u.UUID = :UUID")
})
@Getter
@Setter
public class User implements UserDetails {
    @Id

    @Column(name = "uuid", unique = true, nullable = false)
    private String UUID = java.util.UUID.randomUUID().toString();

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "discount", columnDefinition = "0")
    private Integer discount;

    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Column(name = "username", nullable = false, length = 45, unique = true)
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "is_guest")
    private boolean isGuest = false;
    @Transient
    private List<Roles> roles = List.of(Roles.USER);

    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new LinkedHashSet<>();

    @Column(name = "name", length = 45)
    private String name;


    public User() {
    }

    public User(String UUID, boolean enabled, Integer discount, String password, String username, String email) {
        this.UUID = UUID;
        this.enabled = enabled;
        this.discount = discount;
        this.password = password;
        this.username = username;
        this.email = email;
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuth())).collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled
                && isGuest == user.isGuest
                && Objects.equals(UUID, user.UUID)
                && Objects.equals(discount, user.discount)
                && Objects.equals(password, user.password)
                && Objects.equals(username, user.username)
                && Objects.equals(email, user.email)
                && Objects.equals(phone, user.phone)
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UUID, enabled, discount, password, username, email, phone, isGuest, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "UUID='" + UUID + '\'' +
                ", enabled=" + enabled +
                ", discount=" + discount +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isGuest=" + isGuest +
                ", name='" + name + '\'' +
                '}';
    }
}