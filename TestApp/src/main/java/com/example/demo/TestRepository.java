package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestRepository extends JpaRepository<Test, Long> {
	
	@Query(value = "SELECT * FROM test WHERE is_active = true", nativeQuery = true)
    List<Test> findActiveTestConfigs();
	
}
