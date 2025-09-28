package com.jnbr.student.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jnbr.student.dto.StudentSaveDto;
import com.jnbr.student.dto.StudentUpdateDto;
import com.jnbr.student.entity.Student;

public interface StudentService {
	public Student save(StudentSaveDto dto);
	public Student findById(Long studentId);
	public Page<Student> findAll(Pageable pageable);
	public Student update(Long studentId, StudentUpdateDto dto);
	public Student delete(Long studentId);
}
