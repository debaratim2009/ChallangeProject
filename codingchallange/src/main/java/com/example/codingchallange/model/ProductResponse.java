package com.example.codingchallange.model;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

import com.googlecode.jmapper.annotations.JMap;

import lombok.Getter;
import lombok.Setter;

@Component
public class ProductResponse {
		//@JMap
		private Long productId;
		//@JMap
	    private String name;
	    
	   // @JMap
	    private String status;
	   // @JMap
	    private float price;
	    
	    private Date creationDate;
	    
		public Date getCreationDate() {
			return creationDate;
		}
		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}
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
