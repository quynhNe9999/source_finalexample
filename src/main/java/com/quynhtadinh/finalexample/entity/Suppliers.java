package com.quynhtadinh.finalexample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private long id;
    @JoinColumn(name = "name")
    private String name;
    @JoinColumn(name = "address")
    private String address;
    @JoinColumn(name = "phone")
    private String phone;
    @JoinColumn(name = "email")
    private String email;
    @JoinColumn(name = "status")
    private String status;

}
