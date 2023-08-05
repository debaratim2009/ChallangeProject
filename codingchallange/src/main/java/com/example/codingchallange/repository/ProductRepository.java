package com.example.codingchallange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.codingchallange.Entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	@Query("SELECT p FROM Product p WHERE p.status='active' order by p.Created")
	List<Product> getActiveProducts();
	
	@Query("SELECT p FROM Product p,Queue aq WHERE p.id=aq.id order by p.Created desc ")
	List<Product> getPendingApprovalProducts();

}
