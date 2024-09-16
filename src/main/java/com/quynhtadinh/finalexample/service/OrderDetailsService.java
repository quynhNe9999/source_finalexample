package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.OrderDetails;
import com.quynhtadinh.finalexample.entity.Orders;
import com.quynhtadinh.finalexample.repository.OrderDetailsRepository;
import com.quynhtadinh.finalexample.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    // Add OrderDetail
    public OrderDetails addOrderDetail(Long orderId, OrderDetails orderDetail) {
        Orders order = ordersRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        orderDetail.setOrder(order);
        return orderDetailRepository.save(orderDetail);
    }

    // Update OrderDetail
    public OrderDetails updateOrderDetail(Long orderDetailId, OrderDetails updatedOrderDetail) {
        OrderDetails orderDetail = orderDetailRepository.findById(orderDetailId)
                .orElseThrow(() -> new RuntimeException("OrderDetail not found"));
        orderDetail.setProduct(updatedOrderDetail.getProduct());
        orderDetail.setQuantity(updatedOrderDetail.getQuantity());
        orderDetail.setPrice(updatedOrderDetail.getPrice());
        return orderDetailRepository.save(orderDetail);
    }

    // Delete OrderDetail
    public void deleteOrderDetail(Long orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
    }

    // Get all OrderDetails for a specific Order
    public List<OrderDetails> getOrderDetailsByOrderId(Long orderId) {
        Orders order = ordersRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        return order.getOrderDetails();
    }
}
