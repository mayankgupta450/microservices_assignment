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
		return orderRepository.findAll();
	}

}
