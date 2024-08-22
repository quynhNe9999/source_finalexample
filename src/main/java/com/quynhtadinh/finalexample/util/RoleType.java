package com.quynhtadinh.finalexample.util;


public enum RoleType {
    ROLE_ADMIN(1),
    ROLE_MANAGE(2),
    ROLE_EMPLOYEE(3);

    private final int value;

    RoleType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

