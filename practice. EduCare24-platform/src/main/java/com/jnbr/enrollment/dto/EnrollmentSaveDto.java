package com.jnbr.enrollment.dto;

import java.time.LocalDate;

import com.jnbr.course.entity.Course;
import com.jnbr.enrollment.entity.Enrollment;
import com.jnbr.student.entity.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnrollmentSaveDto {
	private Long studentId;
	private Long courseId;
	private String paymentMethod;
	private Long amount;
	
	public Enrollment toEntity(Student student, Course course) {
		return Enrollment.builder()
			.student(student)
			.course(course)
			.enrollDate(LocalDate.now())
			.paymentMethod(this.paymentMethod)
			.amount(this.amount)
			.build();
	}
}
