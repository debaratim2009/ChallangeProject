package com.example.codingchallange.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	public Long getProductId() {
		return ID;
	}

	public Long setProductId() {
		return ID;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false, unique = true)
	private Long ID;

	@Column(name = "Name")
	private String name;

	@Column(name = "Status")
	private String status;

	@Column(name = "stat")
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "price")
	private float price;

	@Column(name = "Created")
	private Date Created;

	public Date getCreationDate() {
		return Created;
	}

	public void setCreationDate(Date creationDate) {
		this.Created = creationDate;
	}
}
