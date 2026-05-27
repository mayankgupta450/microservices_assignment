package com.order_service.customers;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.order_service.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Value;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductCustomer {

	private final RestClient restClient;

	@Value("${product.service.url}")
	private String productServiceUrl;

	public ProductResponse getProductById(String productId) {

		return restClient.get().uri(productServiceUrl + "/" + productId).retrieve().body(ProductResponse.class);
	}

}
