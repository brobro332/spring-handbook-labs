package com.jnbr.student.dto;

import com.jnbr.student.entity.Student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentSaveDto {
	private String name;
	private String email;
	
	public Student toEntity() {
		return Student.builder()
			.name(this.name)
			.email(this.email)
			.build();
	}
}
