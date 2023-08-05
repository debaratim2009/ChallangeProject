package com.example.codingchallange.service.util;

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
import com.example.codingchallange.service.ProductService;

@Service
public class ProductServiceUtil implements ProductService {
	private static final int _5000 = 5000;

	private static final int MAXPRICE = 10000;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ApprovalQueueRepository queueRepository;

	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	DbUtil dbUtil;
	
	


	public List<ProductResponse> getProducts()throws Exception {
		System.out.print(productRepository.getActiveProducts());
		List<Product> products = productRepository.getActiveProducts();
		List<ProductResponse> productDtoList = mapProduct(products);
		System.out.print("Product is===>" + products.get(0));
		return productDtoList;

	}

	private List<ProductResponse> mapProduct(List<Product> products) {
		List<ProductResponse> dtoList = new ArrayList();
		for (Product product : products) {
			ProductResponse prodDto = productMapper.mapProduct(product);
			dtoList.add(prodDto);
		}
		return dtoList;

	}

	public void createProduct(ProductRequest productRequest) throws Exception {
		
		if (productRequest.getPrice() > MAXPRICE)
			throw new ValidationException("Product Price Must Be Less Than MaxPrice " + MAXPRICE);
		Product product = productMapper.mapRequestToProduct(productRequest);
		Product createdProduct = productRepository.save(product);

		if (productRequest.getPrice() > _5000) {
			QueueDto queueDto = new QueueDto();
			queueDto.setId(createdProduct.getProductId());
			queueRepository.save(productMapper.mapQueue(queueDto));

		}
	
	}

	public void updateProduct(Long id, ProductRequest productRequest) throws Exception {
		if (productRequest.getPrice() > MAXPRICE)
			throw new ValidationException("Product Price Must Be Less Than MaxPrice " + MAXPRICE);
		
		if(id == null)
			throw new ValidationException("ID can't be empty");
		Product updateProduct = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));
		if(productRequest.getPrice()>(updateProduct.getPrice()+updateProduct.getPrice()/2)) {
			QueueDto queueDto = new QueueDto();
			queueDto.setId(id);
			queueRepository.save(productMapper.mapQueue(queueDto));
		}
		updateProduct.setName(productRequest.getName());
		updateProduct.setPrice(productRequest.getPrice());
		updateProduct.setStatus(productRequest.getStatus());

		productRepository.save(updateProduct);

	}

	public void deleteProduct(Long id) throws Exception {
		if(id == null)
			throw new ValidationException("ID can't be empty");
		Product deleteProduct = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));
		QueueDto queueDto = new QueueDto();
		queueDto.setId(id);
		queueRepository.save(productMapper.mapQueue(queueDto));
		productRepository.delete(deleteProduct);

	}

	public List<ProductResponse> getProductsFromApprovalQueue() throws Exception {
		List<Product> products = productRepository.getPendingApprovalProducts();
		List<ProductResponse> productDtoList = mapProduct(products);
		System.out.print("Product is===>" + products.get(0));
		return productDtoList;

	}

	public void approveProduct(Long id) throws Exception {
		Queue updateQueue = queueRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist in approval queue: " + id));
		Product updateProduct = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));
		updateProduct.setState("Approved");
		productRepository.save(updateProduct);
		queueRepository.delete(updateQueue);

	}

	public void rejectProduct(Long id) throws Exception {
		Queue updateQueue = queueRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist in approval queue: " + id));
		queueRepository.delete(updateQueue);

	}
	
	public List<ProductResponse> searchProducts(String prodName,Float minPrice,Float maxPrice,Date minPostedDate,Date maxPostedDate){
		List<ProductResponse> products = dbUtil.searchProducts(prodName,minPrice,maxPrice,minPostedDate,maxPostedDate);
		/*List<ProductResponse> productDtoList = mapProduct(products);
		System.out.print("Product is===>" + products.get(0));*/
		return products;
		
	}
}
