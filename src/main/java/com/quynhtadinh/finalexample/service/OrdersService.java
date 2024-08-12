package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Customers;
import com.quynhtadinh.finalexample.entity.OrderDetails;
import com.quynhtadinh.finalexample.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public interface OrdersService {
    Orders getOrdersById(Long id);

    Orders updateOrders(Orders orders);

    void deleteOrdersById(Long id);

    List<Orders> getAllOrders();

    Orders saveOrders(Orders orders);
}
