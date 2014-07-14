package com.packt.webstore.repository;

import java.util.List;

import com.packt.webstore.domain.Product;

public interface ProductRepository {

	public List <Product> getAllProducts();
	
	public Product getProductById(String productId);
}
