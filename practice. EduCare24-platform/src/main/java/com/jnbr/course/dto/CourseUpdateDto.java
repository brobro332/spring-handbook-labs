package com.jnbr.course.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseUpdateDto {
	private String courseName;
	private Long price;
	private Long catId;
}
