package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.OrderDetails;
import com.quynhtadinh.finalexample.entity.Orders;
import com.quynhtadinh.finalexample.repository.OrdersRepository;
import com.quynhtadinh.finalexample.service.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	@Autowired
	private OrdersRepository ordersRepository;


	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/orders")
	String showOrders(Model map) {
		List<Orders> orders = ordersService.getAllActiveOrders();
		map.addAttribute("orders", orders);
		return "orders";
	}

	@GetMapping(value = { "/add-order"})
	public String addOrders(Model model) {
		model.addAttribute("orders", new Orders());
		return "add-order";
	}

	@PostMapping(value = { "/saveOrders"})
	public String addOrdersPages(@ModelAttribute("orders") Orders orders,
								 @RequestParam("name") String customerName,
								 @RequestParam("email") String customerEmail,
								 @RequestParam("address") String customerAddress,
								 @RequestParam("phone") String customerPhone,
								 List<OrderDetails> newOrderDetails) {

		ordersService.saveOrderWithCustomer(orders, customerName, customerEmail, customerPhone, customerAddress);
		ordersService.saveOrders(orders);
		return "redirect:/orders";
	}

	@RequestMapping("/edit-orders/{id}")
	public ModelAndView showEditOrdersPage(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit-order");
		Orders orders = ordersService.getOrdersById(id).get();
		mav.addObject("orders", orders);
		return mav;
	}
	@PostMapping(value = { "/saveOrdersDetails"})
	public void updateOrder(Orders order, List<OrderDetails> newOrderDetails) {
		order.getOrderDetails().clear();
		order.getOrderDetails().addAll(newOrderDetails);
		ordersRepository.save(order);

	}
	@GetMapping("/delete-orders/{id}")
	public String deleteOrders(@PathVariable Long id) {
		ordersService.deleteOrders(id);
		return "redirect:/orders";
	}

}
