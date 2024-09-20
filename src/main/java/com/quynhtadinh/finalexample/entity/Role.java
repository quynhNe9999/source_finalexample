package com.quynhtadinh.finalexample.entity;

import com.quynhtadinh.finalexample.util.RoleType;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private RoleType name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users; // Đảm bảo rằng tên thuộc tính khớp với tên trong lớp User

}
