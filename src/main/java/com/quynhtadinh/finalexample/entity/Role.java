package com.quynhtadinh.finalexample.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Data
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    @Column(name = "role_name")
    private String role_name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users; // Đảm bảo rằng tên thuộc tính khớp với tên trong lớp User

    @Override
    public String toString() {
        return this.role_name; // Returns the role name, e.g., "ROLE_ADMIN"
    }

public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
