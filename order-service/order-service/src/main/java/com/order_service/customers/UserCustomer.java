package com.order_service.customers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.order_service.dto.UserResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserCustomer {
	
	private final RestClient restClient;

	@Value("${user.service.url}")
	private String userServiceUrl;

	public UserResponse getUserById(Long userId) {

		return restClient.get().uri(userServiceUrl + "/" + userId).retrieve().body(UserResponse.class);
	}

}
