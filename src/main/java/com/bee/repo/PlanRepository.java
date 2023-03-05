package com.bee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bee.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long>{

	Plan findByName(String name);
}
