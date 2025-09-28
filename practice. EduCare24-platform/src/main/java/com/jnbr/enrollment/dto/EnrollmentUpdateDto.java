package com.jnbr.enrollment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnrollmentUpdateDto {
	private Long studentId;
	private Long courseId;
	private String paymentMethod;
	private Long amount;
}
