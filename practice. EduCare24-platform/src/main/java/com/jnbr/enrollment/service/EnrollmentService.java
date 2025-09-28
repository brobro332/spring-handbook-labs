package com.jnbr.enrollment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.jnbr.enrollment.dto.EnrollmentResponseDto;
import com.jnbr.enrollment.dto.EnrollmentSaveDto;
import com.jnbr.enrollment.dto.EnrollmentStatisticsResponseDto;
import com.jnbr.enrollment.dto.EnrollmentUpdateDto;
import com.jnbr.enrollment.entity.Enrollment;

public interface EnrollmentService {
	public EnrollmentResponseDto save(EnrollmentSaveDto dto);
	public EnrollmentResponseDto findByIdWithRelation(Long enrollmentId);
	public Enrollment findEntityById(Long enrollmentId);
	public Page<Enrollment> findAllWithRelation(Pageable pageable);
	public Slice<EnrollmentStatisticsResponseDto> findStatistics(Pageable pageable);
	public EnrollmentResponseDto update(Long enrollmentId, EnrollmentUpdateDto dto);
	public EnrollmentResponseDto delete(Long enrollmentId);
}
