package com.bee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bee.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{

	Brand findByName(String name);
}
