package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	@Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT 3", nativeQuery = true)
	List<Question> findRandomQue();
	
//	@Query(value = "SELECT * FROM question q WHERE q.category_id = :categoryId LIMIT :limit", nativeQuery = true)
//    List<Question> findQuestionsByCategoryIdWithLimit(@Param("categoryId") Long categoryId, @Param("limit") int limit);
//	
	
	@Query(value = "SELECT * FROM question q WHERE q.category_id = :categoryId AND q.level = :level LIMIT :limit", nativeQuery = true)
    List<Question> findQuestionsByCategoryIdAndLevelWithLimit(@Param("categoryId") Long categoryId, @Param("level") String level, @Param("limit") int limit);
	@Query(value = "select * from question q where q.category_id = :catid",nativeQuery = true)
	List<Question> findQuestionByCategoryId(long catid);
}
