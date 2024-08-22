package com.quynhtadinh.finalexample.util;

public enum Role {
    ROLE_ADMIN(1),
    ROLE_MANAGE(2),
    ROLE_EMPLOYEE(3);

    private final int id;

    Role(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
