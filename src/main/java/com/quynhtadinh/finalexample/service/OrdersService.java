package com.quynhtadinh.finalexample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quynhtadinh.finalexample.entity.Orders;

@Service
public interface OrdersService {
    Orders getOrdersById(Long id);

    Orders updateOrders(Orders orders);

    void deleteOrdersById(Long id);

    List<Orders> getAllOrders();

    Orders saveOrders(Orders orders);
}
