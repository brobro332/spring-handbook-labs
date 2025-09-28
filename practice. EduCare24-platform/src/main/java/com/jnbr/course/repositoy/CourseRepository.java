package com.jnbr.course.repositoy;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jnbr.course.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{
	@Query("""
		SELECT     co
		FROM       Course co
		JOIN FETCH co.category ca 
		WHERE      co.courseId = :courseId
	""")
	Optional<Course> findByIdWithCategory(@Param(value = "courseId") Long courseId);
	
	@Query(
		value = """
			SELECT     co
			FROM       Course co
			JOIN FETCH co.category ca 
		""",
		countQuery = "SELECT count(co) FROM Course co"
	)
	Page<Course> findAllWithCategory(Pageable pageable);
}
