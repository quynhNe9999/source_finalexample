package com.quynhtadinh.finalexample.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "import")
public class Import {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private long id;
    @JoinColumn(name = "importDate")
    private Date importDate;

    @JoinColumn(name = "totalCost")
    private Float totalCost;

    @JoinColumn(name = "nhap_xuat")
    private String nhapXuat;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Suppliers supplier;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}

