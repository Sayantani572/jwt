package com.example.inn.product.Consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inn.product.Consumer.dao.productDAO;
import com.example.inn.product.Consumer.entity.Product;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	productDAO productdao;
	
	@PostMapping("/registerProduct")
	public String createProduct(@RequestBody Product prd) {
		productdao.save(prd);
		return "Successfully registered: "+prd.getProductName();
	}
	
	@GetMapping("/products")
	public List<Product> getAllProduct() {
	return	productdao.findAll();
	}
	
	
}
