package com.jnbr.enrollment.service;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jnbr.course.dto.CourseResponseDto;
import com.jnbr.course.entity.Course;
import com.jnbr.course.service.CourseService;
import com.jnbr.enrollment.dto.EnrollmentResponseDto;
import com.jnbr.enrollment.dto.EnrollmentSaveDto;
import com.jnbr.enrollment.dto.EnrollmentStatisticsResponseDto;
import com.jnbr.enrollment.dto.EnrollmentUpdateDto;
import com.jnbr.enrollment.entity.Enrollment;
import com.jnbr.enrollment.repository.EnrollmentRepository;
import com.jnbr.student.entity.Student;
import com.jnbr.student.service.StudentService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
	private final StudentService studentService;
	private final CourseService courseService;
	private final EnrollmentRepository repository;
	
	@Override
	@Transactional
	public EnrollmentResponseDto save(EnrollmentSaveDto dto) {
		Student student = studentService.findById(dto.getStudentId());
		Course course = courseService.findEntityById(dto.getCourseId());
		
		if (student == null) throw new EntityNotFoundException("학생");
		if (course == null) throw new EntityNotFoundException("강좌");
		
		return new EnrollmentResponseDto(student, new CourseResponseDto(course), repository.save(dto.toEntity(student, course)));
	}

	@Override
	public EnrollmentResponseDto findByIdWithRelation(Long enrollmentId) {
		return new EnrollmentResponseDto(repository.findByIdWithRelation(enrollmentId).orElse(null));
	}

	@Override
	public Enrollment findEntityById(Long enrollmentId) {
		return repository.findByIdWithRelation(enrollmentId).orElse(null);
	}

	@Override
	public Page<Enrollment> findAllWithRelation(Pageable pageable) {
		return repository.findAllWithRelation(pageable);
	}
	
	@Override
	public Slice<EnrollmentStatisticsResponseDto> findStatistics(Pageable pageable) {
		return repository.findStatistics(pageable);
	}

	@Override
	@Transactional
	public EnrollmentResponseDto update(Long enrollmentId, EnrollmentUpdateDto dto) {
		Enrollment enrollment = findEntityById(enrollmentId);
		
		if (enrollment == null) throw new EntityNotFoundException("등록");
		
		Student student = studentService.findById(dto.getStudentId());
		Course course = courseService.findEntityById(dto.getCourseId());
		
		if (student == null) throw new EntityNotFoundException("학생");
		if (course == null) throw new EntityNotFoundException("강좌");
		
		enrollment.updateStudent(student);
		enrollment.updateCourse(course);
		enrollment.updateEnrollDate(LocalDate.now());
		enrollment.updatePaymentMethod(dto.getPaymentMethod());
		enrollment.updateAmount(dto.getAmount());
		
		return new EnrollmentResponseDto(enrollment);
	}

	@Override
	@Transactional
	public EnrollmentResponseDto delete(Long enrollmentId) {
		Enrollment enrollment = findEntityById(enrollmentId);
		
		if (enrollment == null) throw new EntityNotFoundException("등록");
		
		repository.delete(enrollment);
		
		return new EnrollmentResponseDto(enrollment);
	}
}
