package com.quynhtadinh.finalexample.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private long id;

    @CreationTimestamp
    @JoinColumn(name = "order_date" , nullable = false)
    private Date orderDate;

    @JoinColumn(name = "total_amount")
    private Float totalAmount;

    @JoinColumn(name = "status")
    private String status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetails> orderDetails;

}
