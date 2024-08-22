package com.quynhtadinh.finalexample.entity;
import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock")
    private Integer stock;

//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;

//    @ManyToOne
//    @JoinColumn(name = "supplier_id")
//    private Suppliers supplier;

    // Getters và Setters
}
