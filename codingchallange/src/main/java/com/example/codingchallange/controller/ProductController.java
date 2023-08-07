package com.example.codingchallange.controller;

import java.util.Date;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.codingchallange.Entity.Product;
import com.example.codingchallange.model.ProductResponse;
import com.example.codingchallange.service.ProductService;
import com.example.codingchallange.model.ProductRequest;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductResponse>> getProducts() throws Exception {
	
		List<ProductResponse> products = productService.getProducts();
		return new ResponseEntity(products, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/products/search")
	public ResponseEntity<List<ProductResponse>> searchProducts(@RequestParam(required = false) String prodName,
			@RequestParam(required = false) Float minPrice, @RequestParam(required = false) Float maxPrice,
			@RequestParam(required = false) String minPostedDate, @RequestParam(required = false) String maxPostedDate)
			throws Exception {
				
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date minimumPostedDate = null;
		Date maximumPostedDate = null;
		if (minPostedDate != null)
			minimumPostedDate = formatter.parse(minPostedDate);
		if (maxPostedDate != null)
			maximumPostedDate = formatter.parse(maxPostedDate);
		List<ProductResponse> products = productService.searchProducts(prodName,minPrice,maxPrice,minimumPostedDate,maximumPostedDate);
		return new ResponseEntity(products, HttpStatus.OK);
		
	}
	@PostMapping(value = "/product")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) throws Exception {
	
		productService.createProduct(productRequest);
		return new ResponseEntity("Product Created", HttpStatus.OK);
		
	}
	
	 @PutMapping(value = "/product/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<String> updateProduct(@PathVariable( "id" ) String id, @RequestBody ProductRequest productRequest) throws Exception {
		 if(id == null)
				throw new ValidationException("ID Can't be Null!!");	
		 productService.updateProduct(Long.parseLong(id),productRequest);
			return new ResponseEntity("Product Updated", HttpStatus.OK);

	    }
	 
	 @DeleteMapping(value = "/product/{id}")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<String> deleteProduct(@PathVariable( "id" ) String id) throws Exception {
			if(id == null)
				throw new ValidationException("ID Can't be Null!!");
		    productService.deleteProduct(Long.parseLong(id));
			return new ResponseEntity("Product Deleted", HttpStatus.OK);

	    }
	 @GetMapping(value = "/products/approval-queue")
		public ResponseEntity<List<ProductResponse>> getProductsFromApprovalQueue() throws Exception {
		
			List<ProductResponse> products = productService.getProductsFromApprovalQueue();
			return new ResponseEntity(products, HttpStatus.OK);
			
		}
	 
	 @PutMapping(value = "/products/approval-queue/{approvalId}/approve")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<String> approveProduct(@PathVariable( "approvalId" ) String id) throws Exception {
		 if(id == null)
				throw new ValidationException("ID Can't be Null!!");	
		 productService.approveProduct(Long.parseLong(id));
		 return new ResponseEntity("Product Approved", HttpStatus.OK);

	    }
	 
	 @PutMapping(value = "/products/approval-queue/{approvalId}/reject")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<String> rejectProduct(@PathVariable( "approvalId" ) String id) throws Exception {
		 if(id == null)
				throw new ValidationException("ID Can't be Null!!");	
		 	productService.rejectProduct(Long.parseLong(id));
			return new ResponseEntity("Product Rejected", HttpStatus.OK);

	    }
	
	
}
