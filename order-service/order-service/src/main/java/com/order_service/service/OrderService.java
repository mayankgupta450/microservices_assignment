package com.order_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.order_service.customers.UserCustomer;
import com.order_service.entity.Order;
import com.order_service.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	private final UserCustomer userCustomer;

	public Order createOrder(Order order) {

		try {
			userCustomer.getUserById(order.getUserId());
		} catch (RestClientException ex) {
			throw new RuntimeException("Invalid user id. User does not exist");
		}

		order.setOrderDate(LocalDateTime.now());
		order.setStatus("CREATED");

		return orderRepository.save(order);
	}

	public List<Order> getAllOrders() {
		List<Order> orders = orderRepository.findAll();

		if (orders.isEmpty()) {
			throw new RuntimeException("No orders available at the moment");
		}

		return orders;
	}

	public Order getOrderById(Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id-" + id));
	}

	public List<Order> getOrdersByUserId(Long userId) {

	    try {
	    	userCustomer.getUserById(userId);
	    } catch (Exception ex) {
	        throw new RuntimeException("Invalid user id or user does not exist:- " + userId);
	    }

	    List<Order> orders = orderRepository.findByUserId(userId);

	    if (orders.isEmpty()) {
	        throw new RuntimeException("No orders found for user id: " + userId);
	    }

	    return orders;
	}

}
