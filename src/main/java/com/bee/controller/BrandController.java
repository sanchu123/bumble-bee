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

import com.bee.entity.Brand;
import com.bee.service.BrandService;

@RestController
@CrossOrigin
public class BrandController {
	
	@Autowired
	private BrandService service;

	@PostMapping(value = "/brands")
	public ResponseEntity<?> create(@RequestBody Brand brand) throws Exception {
		
		if(service.existByName(brand.getName())) {
			return ResponseEntity.badRequest().body("Name Alreday Exists");
		}
		Brand data = service.save(brand);
		return ResponseEntity.ok(data);
	}
	
	@GetMapping(value = "/brands")
	public ResponseEntity<?> getAll() throws Exception {
		List<Brand> cat = service.getAll();
		return ResponseEntity.ok(cat);
	}
	
	@GetMapping(value = "/brands/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) throws Exception {
		Brand cat = service.get(id);
		return ResponseEntity.ok(cat);
	}
	
	@PutMapping(value = "/brands/{id}")
	public ResponseEntity<?> update(@PathVariable long id,@RequestBody Brand brand) throws Exception {
		Brand data = service.update(id,brand);
		return ResponseEntity.ok(data);
	}
	
	@DeleteMapping(value = "/brands/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) throws Exception {
		service.delete(id);
		return ResponseEntity.ok(id);
	}
}
