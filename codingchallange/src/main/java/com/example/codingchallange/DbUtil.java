package com.example.codingchallange;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.codingchallange.Entity.Product;
import com.example.codingchallange.model.ProductResponse;
import com.example.codingchallange.mapping.ProductRowMapper;
@Component
public class DbUtil {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	

	
	public List<Product> searchProducts(String name,Float minPrice,Float maxPrice,Date minPostedDate,Date maxPostedDate){
		StringBuilder query =  new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		query.append("SELECT * FROM Product p Where");
		if(name!=null && !name.isEmpty()) {
			query.append(" p.name = :name ");
			params.put("name", name);
		}
		if(minPostedDate!=null && maxPostedDate!=null) {
			query.append(" and p.created between :minPostedDate and :maxPostedDate ");
			params.put("minPostedDate", minPostedDate);
			params.put("maxPostedDate", maxPostedDate);

		}
		
		if(minPostedDate!=null && maxPostedDate!=null) {
			query.append(" and p.price between :minPrice and :maxPrice ");
			params.put("minPrice", minPrice);
			params.put("maxPrice", maxPrice);

		}
		List<Product> products = jdbcTemplate.query(query.toString(), params,new ProductRowMapper());
		return products;
		
	}


}
