package com.bee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bee.entity.Plan;
import com.bee.entity.Product;
import com.bee.entity.Purchase;
import com.bee.entity.User;
import com.bee.repo.PurchaseRepository;
import com.bee.request.PurchaseRequest;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository repository;
	

	public Purchase save(PurchaseRequest request) {
		Purchase data = new Purchase();
		data.setDescription(request.getDescription());
		data.setStatus(request.getStatus());
		data.setPlan(new Plan(request.getPlan_id()));
		data.setProduct(new Product(request.getProduct_id()));
		data.setUser(new User(request.getUser_id()));
		return repository.save(data);
	}

	public List<Purchase> getAll() {
		return repository.findAll();
	}

	public Purchase get(long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Purchase update(long id,PurchaseRequest request) {
		Purchase data = repository.findById(id).orElse(null);
		data.setDescription(request.getDescription());
		data.setStatus(request.getStatus());
		return repository.save(data);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}
