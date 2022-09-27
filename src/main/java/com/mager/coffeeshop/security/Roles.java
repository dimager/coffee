package com.mager.coffeeshop.security;

public enum Roles {
    ADMIN, USER;

    public String getAuth() {
        return "ROLE_" + this.name();
    }
}
