package com.example.codingchallange.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.codingchallange.Entity.Product;
import com.example.codingchallange.model.ProductResponse;
@Component
public class ProductRowMapper implements RowMapper {
	
	public ProductResponse mapRow(ResultSet rs, int arg1) throws SQLException {

		ProductResponse product = new ProductResponse();

		if (rs.getString("ID") != null)
			product.setProductId(rs.getLong("ID"));
		if (rs.getString("Name") != null)
			product.setName(rs.getString("Name"));
		if (rs.getString("price") != null)
			product.setPrice(Float.parseFloat(rs.getString("price")));
		if (rs.getString("Status") != null)
			product.setStatus(rs.getString("Status"));
		if (rs.getString("Created") != null)
			product.setCreationDate(rs.getDate("Created"));
		return product;

	}
		

}
