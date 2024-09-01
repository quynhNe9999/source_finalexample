package com.quynhtadinh.finalexample.entity;


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
@Table(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "order_detail_id")
    private long order_detail_id;
    @JoinColumn(name = "quantity")
    private long quantity;
    @JoinColumn(name = "price")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Category product;


    public long getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(long order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Category getProduct() {
        return product;
    }

    public void setProduct(Category product) {
        this.product = product;
    }
}

