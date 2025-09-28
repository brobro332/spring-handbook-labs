package com.jnbr.student.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jnbr.student.dto.StudentSaveDto;
import com.jnbr.student.dto.StudentUpdateDto;
import com.jnbr.student.entity.Student;
import com.jnbr.student.repository.StudentRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	private final StudentRepository repository;

	@Override
	@Transactional
	public Student save(StudentSaveDto dto) {
		return repository.save(dto.toEntity());
	}

	@Override
	public Student findById(Long studentId) {
		return repository.findById(studentId).orElse(null);
	}

	@Override
	public Page<Student> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional
	public Student update(Long studentId, StudentUpdateDto dto) {
		Student student = findById(studentId);
		
		if (student == null) throw new EntityNotFoundException("학생");
		
		student.updateName(dto.getName());
		student.updateEmail(dto.getEmail());
		
		return student;
	}

	@Override
	@Transactional
	public Student delete(Long studentId) {
		Student student = findById(studentId);
		
		if (student == null) throw new EntityNotFoundException("학생");
		
		repository.delete(student);
		
		return student;
	}
}
