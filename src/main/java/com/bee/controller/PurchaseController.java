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

import com.bee.entity.Purchase;
import com.bee.request.PurchaseRequest;
import com.bee.service.PlanService;
import com.bee.service.ProductService;
import com.bee.service.PurchaseService;
import com.bee.service.UserService;

@RestController
@CrossOrigin
public class PurchaseController {
	@Autowired
	private PurchaseService service;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PlanService planService;
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/purchases")
	public ResponseEntity<?> create(@RequestBody PurchaseRequest request) throws Exception {
		
		if(productService.get(request.getProduct_id()) == null) {
			return ResponseEntity.badRequest().body("Product Not Found");
		}
		
		if(planService.get(request.getPlan_id()) == null) {
			return ResponseEntity.badRequest().body("Plan Not Found");
		}
		
		if(userService.get(request.getUser_id()) == null) {
			return ResponseEntity.badRequest().body("User Not Found");
		}
		
		Purchase data = service.save(request);
		return ResponseEntity.ok(data);
	}
	
	@GetMapping(value = "/purchases")
	public ResponseEntity<?> getAll() throws Exception {
		List<Purchase> data = service.getAll();
		return ResponseEntity.ok(data);
	}
	
	@GetMapping(value = "/purchases/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) throws Exception {
		Purchase data = service.get(id);
		return ResponseEntity.ok(data);
	}
	
	@PutMapping(value = "/purchases/{id}")
	public ResponseEntity<?> update(@PathVariable long id,@RequestBody PurchaseRequest request) throws Exception {
		Purchase data = service.update(id,request);
		return ResponseEntity.ok(data);
	}
	
	@DeleteMapping(value = "/purchases/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) throws Exception {
		service.delete(id);
		return ResponseEntity.ok(id);
	}
}
