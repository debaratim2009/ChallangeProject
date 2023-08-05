package com.example.codingchallange.mapping;



import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.codingchallange.Entity.Product;
import com.example.codingchallange.Entity.Queue;
import com.example.codingchallange.model.ProductResponse;
import com.example.codingchallange.model.QueueDto;
import com.example.codingchallange.model.ProductRequest;
import com.googlecode.jmapper.JMapper;
@Component
public class ProductMapper {
	public ProductResponse mapProduct(Product product) {
	  /*  JMapper<ProductDto, Product> productMapper = new JMapper<>(ProductDto.class, Product.class);
	    ProductDto productDto = productMapper.getDestination(product);
	    return productDto;*/
		
		ProductResponse productResponse = new ProductResponse();
		productResponse.setName(product.getName());
		productResponse.setPrice(product.getPrice());
		productResponse.setProductId(product.getProductId());
		productResponse.setStatus(product.getStatus());
		
		productResponse.setCreationDate(product.getCreationDate());
		  return productResponse;
		
	}
	
	public Product mapRequestToProduct(ProductRequest productRequest) {
	  Product product = new Product();
	  product.setName(productRequest.getName());
	  product.setPrice(productRequest.getPrice());
	  product.setStatus(productRequest.getStatus());
	  //java.text.SimpleDateFormat sdf = 
		//	     new java.text.SimpleDateFormat("yyyy-MM-dd");

			//String currentDate = sdf.format(new Date());
	  product.setCreationDate(new Date());
	  return product;
		
	}
	
	public Queue mapQueue(QueueDto queueDto) {
		Queue queue = new Queue();
		queue.setProductId(queueDto.getId());
		return queue;
		
	}

}
