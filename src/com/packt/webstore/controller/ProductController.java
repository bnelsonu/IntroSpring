package com.packt.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.domain.Product;
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
	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar="ByCriteria") Map <String,List<String>> 
	filterParams,Model model){
		model.addAttribute("products", productService.getProductByFilter(filterParams));
		return "products";
	}
	
	@RequestMapping("/product")
	public String getProductId(@RequestParam("id") String productId, Model model){
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddNewProductForm(Model model){
		
		//since the get is called first than the post, we create first a key value parameter in the model
		Product newProduct = new Product();
		model.addAttribute("newProduct",newProduct);
		return "addProduct";
	}
	

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct,
			BindingResult result){

		
		//
		String [] supressedFields = result.getSuppressedFields();
		if(supressedFields.length > 0)
		{
			throw new RuntimeException("Attempting to bind disallowed fields:" + StringUtils.arrayToCommaDelimitedString(supressedFields));
		}
		
		//modelAttribute is populated with data enter in the form 
		productService.addProduct(newProduct);
		//using pattern redirect after post
		return "redirect:/products";
	}
	

	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		
		binder.setDisallowedFields("unitsInOrder","discontinued");
	}
	
	
	
/*	@RequestMapping("/{category}/{price}")
	public String getProductsByFilter(@MatrixVariable(pathVar="price") Map <String,List<String>> 
	filterParams,Model model){
		model.addAttribute("products", productService.getProductByFilter(filterParams));
		return "products";
	}*/
	
	
}