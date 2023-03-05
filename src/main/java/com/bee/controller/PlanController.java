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

import com.bee.entity.Plan;
import com.bee.service.PlanService;


@RestController
@CrossOrigin
public class PlanController {

	@Autowired
	private PlanService service;

	@PostMapping(value = "/plans")
	public ResponseEntity<?> create(@RequestBody Plan plan) throws Exception {
		
		if(service.existByName(plan.getName())) {
			return ResponseEntity.badRequest().body("Name Alreday Exists");
		}
		Plan data = service.save(plan);
		return ResponseEntity.ok(data);
	}
	
	@GetMapping(value = "/plans")
	public ResponseEntity<?> getAll() throws Exception {
		List<Plan> plans = service.getAll();
		return ResponseEntity.ok(plans);
	}
	
	@GetMapping(value = "/plans/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) throws Exception {
		Plan plan = service.get(id);
		return ResponseEntity.ok(plan);
	}
	
	@PutMapping(value = "/plans/{id}")
	public ResponseEntity<?> update(@PathVariable long id,@RequestBody Plan plan) throws Exception {
		Plan data = service.update(id,plan);
		return ResponseEntity.ok(data);
	}
	
	@DeleteMapping(value = "/plans/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) throws Exception {
		service.delete(id);
		return ResponseEntity.ok(id);
	}
}
