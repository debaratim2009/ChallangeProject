package com.example.codingchallange.model;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.annotations.JMap;
@Component
public class ProductRequest {
	private Long productId;
	
    private String name;
    
    
    private String status;
    
    private float price;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
