package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Customers;
import com.quynhtadinh.finalexample.entity.OrderDetails;
import com.quynhtadinh.finalexample.repository.CustomersRepository;
import com.quynhtadinh.finalexample.repository.OrderDetailsRepository;
import com.quynhtadinh.finalexample.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quynhtadinh.finalexample.entity.Orders;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

        @Autowired
        private OrdersRepository ordersRepository;

        @Autowired
        private CustomersRepository customersRepository;

        @Autowired
        private OrderDetailsRepository orderDetailsRepository;

        public void updateOrder(Orders order, List<OrderDetails> newOrderDetails) {
            // Clear the existing orderDetails to handle orphan removal properly
            order.getOrderDetails().clear();

            // Add the new details
            order.getOrderDetails().addAll(newOrderDetails);

            // Persist the changes
            ordersRepository.save(order);
        }
        @Transactional
        public void saveOrders(Orders orders) {
            Customers customer = orders.getCustomer();
            if (false) {
                customersRepository.save(customer);
            }
            ordersRepository.save(orders);

        }

    public Orders saveOrderWithCustomer(Orders order, String customerName, String customerEmail, String customerPhone, String customerAddress) {
        // Kiểm tra khách hàng có tồn tại không
        Customers customer = customersRepository.findByName(customerName)
                .orElseGet(() -> {
                    // Nếu không tồn tại, tạo khách hàng mới
                    Customers newCustomer = new Customers();
                    newCustomer.setName(customerName);
                    newCustomer.setEmail(customerEmail);
                    newCustomer.setPhone(customerPhone);
                    newCustomer.setAddress(customerAddress);
                    return customersRepository.save(newCustomer);
                });

        // Gán khách hàng vào đơn hàng
        order.setCustomer(customer);

        // Lưu đơn hàng
        return ordersRepository.save(order);
    }


        public List<Orders> getAllActiveOrders() {
            return ordersRepository.findAll();
        }

        public Optional<Orders> getOrdersById(Long id) {
            return ordersRepository.findById(id);
        }
        public void deleteOrders(Long id) {
            ordersRepository.deleteById(id);
        }
    }

