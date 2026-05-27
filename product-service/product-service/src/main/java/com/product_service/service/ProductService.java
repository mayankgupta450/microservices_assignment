package com.product_service.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.product_service.entity.Product;
import com.product_service.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> getAllProducts() {

		List<Product> products = productRepository.findAll();

		if (products.isEmpty()) {
			throw new NoSuchElementException("No products available at the moment");
		}

		return products;
	}

}
