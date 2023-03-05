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

import com.bee.entity.Category;
import com.bee.service.CategoryService;

@RestController
@CrossOrigin
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@PostMapping(value = "/categories")
	public ResponseEntity<?> create(@RequestBody Category category) throws Exception {
		
		if(service.existByName(category.getName())) {
			return ResponseEntity.badRequest().body("Name Alreday Exists");
		}
		Category cat = service.save(category);
		return ResponseEntity.ok(cat);
	}
	
	@GetMapping(value = "/categories")
	public ResponseEntity<?> getAll() throws Exception {
		List<Category> cat = service.getAll();
		return ResponseEntity.ok(cat);
	}
	
	@GetMapping(value = "/categories/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) throws Exception {
		Category cat = service.get(id);
		return ResponseEntity.ok(cat);
	}
	
	@PutMapping(value = "/categories/{id}")
	public ResponseEntity<?> update(@PathVariable long id,@RequestBody Category category) throws Exception {
		Category cat = service.update(id,category);
		return ResponseEntity.ok(cat);
	}
	
	@DeleteMapping(value = "/categories/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) throws Exception {
		service.delete(id);
		return ResponseEntity.ok(id);
	}
}
