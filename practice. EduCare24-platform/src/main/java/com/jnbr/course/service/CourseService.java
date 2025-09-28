package com.jnbr.course.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jnbr.course.dto.CourseResponseDto;
import com.jnbr.course.dto.CourseSaveDto;
import com.jnbr.course.dto.CourseUpdateDto;
import com.jnbr.course.entity.Course;

public interface CourseService {
	public CourseResponseDto save(CourseSaveDto dto);
	public CourseResponseDto findById(Long courseId);
	public Course findEntityById(Long courseId);
	public Page<Course> findAllWithCategory(Pageable pageable);
	public CourseResponseDto update(Long courseId, CourseUpdateDto dto);
	public CourseResponseDto delete(Long courseId);
}
