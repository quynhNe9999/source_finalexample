package com.quynhtadinh.finalexample.servive.impl;

import com.quynhtadinh.finalexample.entity.OrderDetails;
import com.quynhtadinh.finalexample.repository.OrderDetailsRepository;
import com.quynhtadinh.finalexample.service.OrderDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public OrderDetails getOrderDetailsById(Long id) {
        return null;
    }

    @Override
    public OrderDetails updateOrderDetails(OrderDetails orderDetails) {
        return null;
    }

    @Override
    public void deleteOrderDetailsById(Long id) {

    }

    @Override
    public List<OrderDetails> getAllOrderDetails() {
        return Collections.emptyList();
    }

    @Override
    public OrderDetails saveOrderDetails(OrderDetails orderDetails) {
        return null;
    }
}
