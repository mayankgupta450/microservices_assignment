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

	public Product getProductById(String id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
	}

	public Product updateProduct(String id, Product updatedProduct) {

		Product existingProduct = getProductById(id);

		existingProduct.setName(updatedProduct.getName());
		existingProduct.setDescription(updatedProduct.getDescription());
		existingProduct.setPrice(updatedProduct.getPrice());
		existingProduct.setStock(updatedProduct.getStock());

		return productRepository.save(existingProduct);
	}

	public void deleteProduct(String id) {

		Product existingProduct = getProductById(id);

		productRepository.delete(existingProduct);
	}

}
