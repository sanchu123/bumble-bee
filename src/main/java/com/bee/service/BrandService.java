package com.bee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bee.entity.Brand;
import com.bee.repo.BrandRepository;

@Service
public class BrandService {
	
	@Autowired
	private BrandRepository repository;

	public Boolean existByName(String name) {
		
		Brand cat = repository.findByName(name);
		if(cat != null) {
			return true;
		}
		return false;
	}

	public Brand save(Brand brand) {
		return repository.save(brand);
	}

	public List<Brand> getAll() {
		return repository.findAll();
	}

	public Brand get(long id) {
		return repository.findById(id).orElse(null);
	}

	public Brand update(long id, Brand brand) {
		Brand data = repository.findById(id).orElse(null);
		data.setDescription(brand.getDescription());
		data.setName(brand.getName());
		return repository.save(data);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}
