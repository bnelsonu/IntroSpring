package com.packt.webstore.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository{

	
	private List <Product> listOfProducts = new ArrayList <Product> ();
	
	public InMemoryProductRepository() {
		
		Product iphone = new Product("P1234","iphone 5s",new BigDecimal(500));
		iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-mega"
				+ "pixel rear camera");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		
		
		Product laptop_dell = new Product("P1235","Dell Inspiron",new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core "
				+ "processors");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);
		
		Product tablet_Nexus = new Product("P1236","Google Nexus 7",new BigDecimal(300));
		tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet with a quad-core"
				+ "Qualcomm Sanpdragon S4 Pro processor");
		tablet_Nexus.setCategory("Tablet");
		tablet_Nexus.setManufacturer("Google");
		tablet_Nexus.setUnitsInStock(1000);
		
		listOfProducts.add(iphone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_Nexus);
	}	

	@Override
	public List<Product> getAllProducts() {
	
		return listOfProducts;
	}

	@Override
	public Product getProductById(String productId) {
		
		Product foundProduct = null;
		
		for(Product product: listOfProducts ){
			
			if (product != null && product.getProductoId() != null && productId.equals(product.getProductoId()))
			{
			    foundProduct = product;
			    break;
			}
		}
		
		if (foundProduct==null){
			throw new IllegalArgumentException("No products found with the product id :"+ productId );
		}
		
		return foundProduct;
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		List <Product> productsByCategory = new ArrayList<Product>();
		
		
		for(Product product: listOfProducts ){
			
			if (category.equalsIgnoreCase(product.getCategory()))
			{
				productsByCategory.add(product);
			}
		}
		
		return productsByCategory;
	}

	@Override
	public Set<Product> getProductsByFilter(
			Map<String, List<String>> filterParams) {
		
		/*each matrix variable will be separated by a semicolon  to assign multiple values to a single variable, each value must be separated by a comma or 
		*we can repeat the variable name
		*ByCriteria;brand=google,dell;category=tablet,laptop;
		*/
		
		
		Set <Product> productsByBrand = new HashSet<Product>();
		Set <Product> productsByCategory = new HashSet<Product>();
		
		Set <String> criterias = filterParams.keySet();
		
		if(criterias.contains("brand"))
		{
			
			for(String brandName: filterParams.get("brand"))
			{
				for (Product product :  listOfProducts)
				{
					if(brandName.equalsIgnoreCase(product.getManufacturer()))
					{
						productsByBrand.add(product);
					}
				}
			}
		}
		if (criterias.contains("category"))
		{
			for (String category: filterParams.get("category"))
			{
				productsByCategory.addAll(this.getProductByCategory(category));
			} 
		}
		
		productsByCategory.retainAll(productsByBrand);
						
		return productsByCategory;
	}
}
