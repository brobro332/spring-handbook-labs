package com.jnbr.enrollment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentStatisticsResponseDto {
	private String courseName;
	private Long studentCount;
	private Long totalSales;
}
