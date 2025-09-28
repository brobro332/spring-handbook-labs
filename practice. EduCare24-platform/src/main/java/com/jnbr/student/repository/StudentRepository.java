package com.jnbr.student.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.jnbr.student.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	Page<Student> findAll(Pageable pageable);
}
