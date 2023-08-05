package com.example.codingchallange.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.codingchallange.Entity.Product;
@Component
public class ProductRowMapper implements RowMapper {
	
	public Product mapRow(ResultSet rs, int arg1) throws SQLException {

		Product product = new Product();

		if (rs.getString("ID") != null)
			product.setProductId(rs.getString("ID"));
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
