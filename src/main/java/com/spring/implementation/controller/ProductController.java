package com.spring.implementation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.implementation.model.Products;
import com.spring.implementation.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepo;
	
	@PostMapping("/save")
	public Products saveProducts(@RequestBody Products product) {
		return productRepo.save(product);
	}
	
	@GetMapping("/getById/{id}")
	public Products getById(@PathVariable String id) {
		return productRepo.findById(id).get();
	}
	
	@GetMapping("/getAll")
	public List<Products> getAll(){
		return productRepo.findAll();
	}
	
	@PostMapping("/updatePrice")
	public Products updatePrice(@RequestBody Products product) {
		Optional<Products> prod = productRepo.findById(product.getId());
		if(!prod.isEmpty()) {
			prod.get().setPrice(product.getPrice());
			return productRepo.save(prod.get());
		}
		return productRepo.save(product);
		
	}
	
	@GetMapping("/deleteById/{id}")
	public String deleteById(@PathVariable String id) {
		productRepo.deleteById(id);
		return "Product deleted successfully";
	}
}
