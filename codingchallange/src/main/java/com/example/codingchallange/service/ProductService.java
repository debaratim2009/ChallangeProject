package com.example.codingchallange.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.codingchallange.DbUtil;
import com.example.codingchallange.Entity.Product;
import com.example.codingchallange.Entity.Queue;
import com.example.codingchallange.exception.ResourceNotFoundException;
import com.example.codingchallange.exception.ValidationException;

import com.example.codingchallange.mapping.ProductMapper;
import com.example.codingchallange.model.ProductResponse;
import com.example.codingchallange.model.QueueDto;
import com.example.codingchallange.model.ProductRequest;
import com.example.codingchallange.repository.ApprovalQueueRepository;
import com.example.codingchallange.repository.ProductRepository;

@Service
public interface ProductService {
	
	public List<ProductResponse> getProducts() throws Exception ;
		public void createProduct(ProductRequest productRequest) throws Exception ;
	public void updateProduct(Long id, ProductRequest productRequest) throws Exception ;

	public void deleteProduct(Long id) throws Exception ;

	public List<ProductResponse> getProductsFromApprovalQueue() throws Exception;

	public void approveProduct(Long id) throws Exception;

	public void rejectProduct(Long id) throws Exception;
	
	public List<ProductResponse> searchProducts(String prodName,Float minPrice,Float maxPrice,Date minPostedDate,Date maxPostedDate);
		
}
