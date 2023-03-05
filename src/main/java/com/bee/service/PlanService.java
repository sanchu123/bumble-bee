package com.bee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bee.entity.Plan;
import com.bee.repo.PlanRepository;


@Service
public class PlanService {

	@Autowired
	private PlanRepository repository;

	public Boolean existByName(String name) {
		
		Plan plan = repository.findByName(name);
		if(plan != null) {
			return true;
		}
		return false;
	}

	public Plan save(Plan plan) {
		return repository.save(plan);
	}

	public List<Plan> getAll() {
		return repository.findAll();
	}

	public Plan get(long id) {
		return repository.findById(id).orElse(null);
	}

	public Plan update(long id, Plan plan) {
		Plan data = repository.findById(id).orElse(null);
		data.setName(plan.getName());
		data.setMonths(plan.getMonths());
		data.setNumberOfPayments(plan.getNumberOfPayments());
		return repository.save(data);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}
