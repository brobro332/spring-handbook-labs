package com.jnbr.enrollment.dto;

import java.time.LocalDate;

import com.jnbr.course.dto.CourseResponseDto;
import com.jnbr.enrollment.entity.Enrollment;
import com.jnbr.student.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponseDto {
	private Long enrollmentId;
	private Student student;
	private CourseResponseDto course;
	private LocalDate enrollDate;
	private String paymentMethod;
	private Long amount;
	
	public EnrollmentResponseDto(Enrollment enrollment) {
		this.student = enrollment.getStudent();
		this.course = new CourseResponseDto(enrollment.getCourse());
		this.enrollmentId = enrollment.getEnrollmentId();
		this.enrollDate = enrollment.getEnrollDate();
		this.paymentMethod = enrollment.getPaymentMethod();
		this.amount = enrollment.getAmount();
	}
	
	public EnrollmentResponseDto(Student student, CourseResponseDto course, Enrollment enrollment) {
		this.student = student;
		this.course = course;
		this.enrollmentId = enrollment.getEnrollmentId();
		this.enrollDate = enrollment.getEnrollDate();
		this.paymentMethod = enrollment.getPaymentMethod();
		this.amount = enrollment.getAmount();
	}
}
