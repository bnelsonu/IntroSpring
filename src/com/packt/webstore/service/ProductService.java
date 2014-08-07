package com.packt.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.packt.webstore.domain.Product;

public interface ProductService {
	
	public List <Product> getAllProducts();
	public Product getProductById(String productId);
	public List <Product> getProductByCategory(String category);
	public  List <Product> getProductsByManufacturer(String manufacturer);
	public Set< Product> getProductByFilter(Map<String, List <String>> filterParams );
	public void addProduct (Product product);
}
