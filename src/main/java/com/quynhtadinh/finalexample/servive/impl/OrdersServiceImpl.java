package com.quynhtadinh.finalexample.servive.impl;

import com.quynhtadinh.finalexample.entity.OrderDetails;
import com.quynhtadinh.finalexample.entity.Orders;
import com.quynhtadinh.finalexample.repository.OrdersRepository;
import com.quynhtadinh.finalexample.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class OrdersServiceImpl implements OrdersService {

    private OrdersRepository ordersRepository;

    @Override
    public Orders getOrdersById(Long id) {
        return null;
    }

    @Override
    public Orders updateOrders(Orders orders) {
        return null;
    }

    @Override
    public void deleteOrdersById(Long id) {

    }

    @Override
    public List<Orders> getAllOrders() {
        return Collections.emptyList();
    }

    @Override
    public Orders saveOrders(Orders orders) {
        return null;
    }
}
