package com.jnbr.course.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jnbr.category.entity.Category;
import com.jnbr.category.service.CategoryService;
import com.jnbr.course.dto.CourseResponseDto;
import com.jnbr.course.dto.CourseSaveDto;
import com.jnbr.course.dto.CourseUpdateDto;
import com.jnbr.course.entity.Course;
import com.jnbr.course.repositoy.CourseRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
	private final CategoryService categoryService;
	private final CourseRepository repository;

	@Override
	@Transactional
	public CourseResponseDto save(CourseSaveDto dto) {
		Category category = categoryService.findById(dto.getCatId());
		
		if (category == null) throw new EntityNotFoundException("카테고리");
		
		return new CourseResponseDto(repository.save(dto.toEntity(category)));
	}

	@Override
	public CourseResponseDto findById(Long courseId) {
		return new CourseResponseDto(repository.findByIdWithCategory(courseId).orElse(null));
	}
	
	@Override
	public Course findEntityById(Long courseId) {
		return repository.findById(courseId).orElse(null);
	}

	@Override
	public Page<Course> findAllWithCategory(Pageable pageable) {
		return repository.findAllWithCategory(pageable);
	}

	@Override
	@Transactional
	public CourseResponseDto update(Long courseId, CourseUpdateDto dto) {
		Category category = categoryService.findById(dto.getCatId());
		
		if (category == null) throw new EntityNotFoundException("카테고리");
		
		Course course = findEntityById(courseId);
		
		if (course == null) throw new EntityNotFoundException("강좌");
		
		course.updateCourseName(dto.getCourseName());
		course.updatePrice(dto.getPrice());
		course.updateCategory(category);
		
		return new CourseResponseDto(course);
	}

	@Override
	@Transactional
	public CourseResponseDto delete(Long courseId) {
		Course course = findEntityById(courseId);
		
		if (course == null) throw new EntityNotFoundException("강좌");
		
		repository.delete(course);
		
		return new CourseResponseDto(course);
	}
}
