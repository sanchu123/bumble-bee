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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bee.entity.User;
import com.bee.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping(value = "/users")
	public ResponseEntity<?> create(@RequestBody User request) throws Exception {
		
		if(service.existByName(request.getUsername())) {
			return ResponseEntity.badRequest().body("Name Alreday Exists");
		}
		User user = service.save(request);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<?> getAll(@RequestParam String type) throws Exception {
		List<User> users = service.getAll(type);
		return ResponseEntity.ok(users);
	}
	
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<?> getOne(@PathVariable long id) throws Exception {
		User user = service.get(id);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping(value = "/users/{id}")
	public ResponseEntity<?> update(@PathVariable long id,@RequestBody User user) throws Exception {
		User data = service.update(id,user);
		return ResponseEntity.ok(data);
	}
	
	@DeleteMapping(value = "/users/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) throws Exception {
		service.delete(id);
		return ResponseEntity.ok(id);
	}
}
