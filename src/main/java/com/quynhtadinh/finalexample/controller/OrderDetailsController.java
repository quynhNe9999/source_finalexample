package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.OrderDetails;
import com.quynhtadinh.finalexample.service.OrderDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService orderDetailsService;

	// Add a new OrderDetail
	@PostMapping("/{orderId}/order-details/add")
	public String addOrderDetail(@PathVariable Long orderId, @ModelAttribute OrderDetails orderDetails) {
		orderDetailsService.addOrderDetail(orderId, orderDetails);
		return "redirect:/orders/" + orderId;
	}

	// Update an OrderDetail
	@PostMapping("/order-details/update/{id}")
	public String updateOrderDetail(@PathVariable Long id, @ModelAttribute OrderDetails orderDetails) {
		orderDetailsService.updateOrderDetail(id, orderDetails);
		return "redirect:/orders";
	}

	// Delete an OrderDetail
	@PostMapping("/order-details/delete/{id}")
	public String deleteOrderDetail(@PathVariable Long id) {
		orderDetailsService.deleteOrderDetail(id);
		return "redirect:/orders";
	}
}
