package com.bee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bee.entity.Product;
import com.bee.request.ProductRequest;
import com.bee.service.BrandService;
import com.bee.service.CategoryService;
import com.bee.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping(value = "/products")
	public ResponseEntity<?> create(@RequestBody ProductRequest request) throws Exception {
		
		if(service.existByName(request.getName())) {
			return ResponseEntity.badRequest().body("Name Alreday Exists");
		}
		
		if(brandService.get(request.getBrand_id()) == null) {
			return ResponseEntity.badRequest().body("Brand Not Found");
		}
		
		if(categoryService.get(request.getCategory_id()) == null) {
			return ResponseEntity.badRequest().body("Category Not Found");
		}
		
		Product product = service.save(request);
		return ResponseEntity.ok(product);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<?> getAll() throws Exception {
		List<Product> cat = service.getAll();
		return ResponseEntity.ok(cat);
	}
	
	@GetMapping(value = "/products/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) throws Exception {
		Product product = service.get(id);
		return ResponseEntity.ok(product);
	}
	
	@PutMapping(value = "/products/{id}")
	public ResponseEntity<?> update(@PathVariable long id,@RequestBody ProductRequest request) throws Exception {
		if(brandService.get(request.getBrand_id()) == null) {
			return ResponseEntity.badRequest().body("Brand Not Found");
		}
		
		if(categoryService.get(request.getCategory_id()) == null) {
			return ResponseEntity.badRequest().body("Category Not Found");
		}
		Product product = service.update(id,request);
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping(value = "/products/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) throws Exception {
		service.delete(id);
		return ResponseEntity.ok(id);
	}
}
