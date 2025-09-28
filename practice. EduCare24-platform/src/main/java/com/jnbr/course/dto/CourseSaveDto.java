package com.jnbr.course.dto;

import com.jnbr.category.entity.Category;
import com.jnbr.course.entity.Course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseSaveDto {
	private String courseName;
	private Long price;
	private Long catId;
	
	public Course toEntity(Category category) {
		return Course.builder()
			.courseName(this.courseName)
			.price(this.price)
			.category(category)
			.build();
	}
}
