package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.webstore.service.ProductService;

@Controller
@RequestMapping("/products") 
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@RequestMapping
	public String list (Model model)
	{
		model.addAttribute("products",productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/all") 
	public String allProducts (Model model){
		model.addAttribute("products",productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/{category}")//el path puede ser variable usando @PathVariable
	public String getProductsByCategory(Model model, @PathVariable("category")String
			productCategory){
		
		model.addAttribute("products", productService.getProductByCategory(productCategory));
		return "products";
	}
	
	
}
