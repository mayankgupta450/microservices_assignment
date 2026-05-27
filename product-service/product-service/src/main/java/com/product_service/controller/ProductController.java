package com.product_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product_service.entity.Product;
import com.product_service.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@PostMapping
	@Operation(summary = "create product")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
		return ResponseEntity.ok(productService.createProduct(product));
	}

	@GetMapping
	@Operation(summary = "get products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	@GetMapping("/{id}")
	@Operation(summary = "get products by id")
	public ResponseEntity<Product> getProductById(@PathVariable String id) {
		return ResponseEntity.ok(productService.getProductById(id));
	}

	@PutMapping("/{id}")
	@Operation(summary = "update products")
	public ResponseEntity<Product> updateProduct(@PathVariable String id, @Valid @RequestBody Product product) {

		return ResponseEntity.ok(productService.updateProduct(id, product));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "delete products")
	public ResponseEntity<String> deleteProduct(@PathVariable String id) {

		productService.deleteProduct(id);

		return ResponseEntity.ok("Product deleted successfully");
	}

}
