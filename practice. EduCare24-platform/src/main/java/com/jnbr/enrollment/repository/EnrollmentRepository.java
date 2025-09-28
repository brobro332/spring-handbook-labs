package com.jnbr.enrollment.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jnbr.enrollment.dto.EnrollmentStatisticsResponseDto;
import com.jnbr.enrollment.entity.Enrollment;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Long> {
	
	@Query("""
		SELECT     e
		FROM       Enrollment  e
		JOIN FETCH e.student   s
		JOIN FETCH e.course    co
		JOIN FETCH co.category ca
		WHERE e.enrollmentId = :enrollmentId
	""")
	Optional<Enrollment> findByIdWithRelation(@Param(value = "enrollmentId") Long enrollmentId); 
	
	@Query(
		value = """
			SELECT     e
			FROM       Enrollment  e
			JOIN FETCH e.student   s
			JOIN FETCH e.course    co
			JOIN FETCH co.category ca
		""",
		countQuery = "SELECT COUNT(e) FROM Enrollment e"
	)
	Page<Enrollment> findAllWithRelation(Pageable pageable);
	
	@Query("""
		SELECT     new com.jnbr.enrollment.dto.EnrollmentStatisticsResponseDto(
				       c.courseName,
		               COUNT(e.enrollmentId),
		               SUM(e.amount)
		)
		FROM       Enrollment e
		JOIN       e.course c
		GROUP BY   c.courseName
		ORDER BY   SUM(e.amount) DESC
	""")
	Slice<EnrollmentStatisticsResponseDto> findStatistics(Pageable pageable);
}
