package com.example.codingchallange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.codingchallange.Entity.Product;

//@Repository
public class ApprovalPoductRepository {
	/*@Query("SELECT p FROM Product p,ApprovalQueue aq WHERE p.id=aq.id")
	List<Product> getPendingApprovalProducts();
*/
}
