package com.bee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bee.entity.Category;
import com.bee.repo.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;

	public Boolean existByName(String name) {
		
		Category cat = repository.findByName(name);
		if(cat != null) {
			return true;
		}
		return false;
	}

	public Category save(Category category) {
		return repository.save(category);
	}

	public List<Category> getAll() {
		return repository.findAll();
	}

	public Category get(long id) {
		return repository.findById(id).orElse(null);
	}

	public Category update(long id, Category category) {
		Category cat = repository.findById(id).orElse(null);
		cat.setDescription(category.getDescription());
		cat.setName(category.getName());
		return repository.save(cat);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

}
