package com.jnbr.enrollment.entity;

import java.time.LocalDate;

import com.jnbr.course.entity.Course;
import com.jnbr.student.entity.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TBL_ENROLLMENT")
@SequenceGenerator(
	name = "SEQ_ENROLLMENT_GEN",
	sequenceName = "SEQ_ENROLLMENT",
	initialValue = 1,
	allocationSize = 1
)
public class Enrollment {
	@Id
	@GeneratedValue(generator = "SEQ_ENROLLMENT_GEN", strategy = GenerationType.SEQUENCE)
	private Long enrollmentId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	private Course course;
	
	private LocalDate enrollDate;
	
	@Column(length = 50)
	private String paymentMethod;
	
	private Long amount;
	
	@PrePersist
	public void prePersist() {
	    if (enrollDate == null) enrollDate = LocalDate.now();
	}
	
	public void updateStudent(Student student) {
		this.student = student;
	}
	
	public void updateCourse(Course course) {
		this.course = course;
	}
	
	public void updateEnrollDate(LocalDate enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	public void updatePaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public void updateAmount(Long amount) {
		this.amount = amount;
	}
}
