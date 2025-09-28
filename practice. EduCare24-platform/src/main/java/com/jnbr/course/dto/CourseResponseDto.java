package com.jnbr.course.dto;

import com.jnbr.category.dto.CategoryResponseDto;
import com.jnbr.course.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDto {
	private Long courseId;
	private String courseName;
	private Long price;
	private CategoryResponseDto category;
	
	public CourseResponseDto(Course course) {
		this.courseId = course.getCourseId();
		this.courseName = course.getCourseName();
		this.price = course.getPrice();
		this.category = new CategoryResponseDto(course.getCategory());
	}
}
