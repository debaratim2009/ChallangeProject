package com.example.codingchallange.Entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Queue")
public class Queue {
    public Long getProductId() {
		return id;
	}

	public void setProductId(Long productId) {
		this.id = productId;
	}

	
	@Id
    @Column(name = "ID")
    private Long id;

  
}
