package com.jnbr.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "TBL_STUDENT")
@SequenceGenerator(
	name = "SEQ_STUDENT_GEN",
	sequenceName = "SEQ_STUDENT",
	initialValue = 1,
	allocationSize = 1
)
public class Student {
	@Id
	@GeneratedValue(generator = "SEQ_STUDENT_GEN", strategy = GenerationType.SEQUENCE)
	private Long studentId;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 100, unique = true)
	private String email;
	
	public void updateName(String name) {
		this.name = name;
	}
	
	public void updateEmail(String email) {
		this.email = email;
	}
}
