package com.ecommerce.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Customer;
import com.ecommerce.model.CustomerOrder;
import com.ecommerce.service.CartService;
import com.ecommerce.service.CustomerOrderService;
import com.ecommerce.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;

	@Autowired
	private CartService cartService;

	@Autowired
	private CustomerOrderService customerOrderService;

	@GetMapping("/order/{cartId}")
	public CustomerOrder createOrder(@PathVariable("cartId") int cartId) {

		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setOrderDate(new Date());

		Cart cart = cartService.findById(cartId).get();
		customerOrder.setCart(cart);
		Customer customer = cart.getCustomer();

		customerOrder.setCustomer(customer);
		customerOrder.setAddress(customer.getCustomerAddress());
		customerOrderService.save(customerOrder);

		return customerOrder;
	}

	@GetMapping("/orders")
	public List<CustomerOrder> getOrders() {
		return service.findAll();

	}
}
