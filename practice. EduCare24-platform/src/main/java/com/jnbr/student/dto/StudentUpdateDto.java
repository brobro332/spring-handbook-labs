package com.jnbr.student.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentUpdateDto {
	private String name;
	private String email;
}
