package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.OrderDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailsService {
    OrderDetails getOrderDetailsById(Long id);

    OrderDetails updateOrderDetails(OrderDetails orderDetails);

    void deleteOrderDetailsById(Long id);

    List<OrderDetails> getAllOrderDetails();

    OrderDetails saveOrderDetails(OrderDetails orderDetails);
}
