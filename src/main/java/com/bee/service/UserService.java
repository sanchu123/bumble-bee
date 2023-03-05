package com.bee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bee.entity.User;
import com.bee.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	public Boolean existByName(String name) {
		
		User user = repository.findByUsername(name);
		if(user != null) {
			return true;
		}
		return false;
	}

	public User save(User request) {
		request.setPassword(bcryptEncoder.encode(request.getPassword()));
		return repository.save(request);
	}

	public List<User> getAll(String type) {
		return repository.findAllByType(type);
	}

	public User get(long id) {
		return repository.findById(id).orElse(null);
	}

	public User update(long id, User user) {
		User data = repository.findById(id).orElse(null);
		data.setFullname(user.getFullname());
		data.setBalance(user.getBalance());
		data.setDob(user.getDob());
		return repository.save(data);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}
