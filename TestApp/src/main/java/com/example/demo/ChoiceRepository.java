package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
	
	@Query(value = "delete from choice c where c.question_id = :id",nativeQuery = true)
	@Modifying
    @Transactional
	void deleteChoiceByQuestionId(long id);
	

}

