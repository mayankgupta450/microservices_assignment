package com.order_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
	private String id;
	private String name;
	private String description;
	private Double price;
	private Integer stock;

}
