package com.bee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bee.entity.Brand;
import com.bee.entity.Category;
import com.bee.entity.Product;
import com.bee.repo.ProductRepository;
import com.bee.request.ProductRequest;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Boolean existByName(String name) {
		
		Product pro = repository.findByName(name);
		if(pro != null) {
			return true;
		}
		return false;
	}

	public Product save(ProductRequest request) {
		Product product = new Product();
		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setImage(request.getImage());
		product.setStock(request.getStock());
		product.setBrand(new Brand(request.getBrand_id()));
		product.setCategory(new Category(request.getCategory_id()));
		product.setPrice(request.getPrice());
		return repository.save(product);
	}

	public List<Product> getAll() {
		return repository.findAll();
	}

	public Product get(long id) {
		return repository.findById(id).orElse(null);
	}

	public Product update(long id, ProductRequest request) {
		Product product = repository.findById(id).orElse(null);
		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setImage(request.getImage());
		product.setStock(request.getStock());
		product.setBrand(new Brand(request.getBrand_id()));
		product.setCategory(new Category(request.getCategory_id()));
		product.setPrice(request.getPrice());
		return repository.save(product);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

}
