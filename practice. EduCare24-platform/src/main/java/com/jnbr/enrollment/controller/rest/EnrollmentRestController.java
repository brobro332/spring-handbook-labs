package com.jnbr.enrollment.controller.rest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jnbr.common.dto.CommonResponseDto;
import com.jnbr.enrollment.dto.EnrollmentSaveDto;
import com.jnbr.enrollment.dto.EnrollmentUpdateDto;
import com.jnbr.enrollment.service.EnrollmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/enrollment")
@RequiredArgsConstructor
public class EnrollmentRestController {
	public final EnrollmentService service;
	
	@PostMapping
	public ResponseEntity<CommonResponseDto<?>> save(@RequestBody EnrollmentSaveDto dto) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.save(dto))
			.message("등록 정보 등록에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@GetMapping("/{enrollmentId}")
	public ResponseEntity<CommonResponseDto<?>> findById(@PathVariable Long enrollmentId) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.findByIdWithRelation(enrollmentId))
			.message("등록 단일 목록 조회에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@GetMapping("/all")
	public ResponseEntity<CommonResponseDto<?>> findAll(Pageable pageable) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.findAllWithRelation(pageable))
			.message("등록 전체 목록 조회에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@GetMapping("/course/statistics")
	public ResponseEntity<CommonResponseDto<?>> findStatistics(@PageableDefault(size = 5, page = 0) Pageable pageable) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.findStatistics(pageable))
			.message("강좌 정보 통계 조회에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@PutMapping("/{enrollmentId}")
	public ResponseEntity<CommonResponseDto<?>> update(@PathVariable Long enrollmentId, @RequestBody EnrollmentUpdateDto dto) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.update(enrollmentId, dto))
			.message("등록 정보 수정에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@DeleteMapping("/{enrollmentId}")
	public ResponseEntity<CommonResponseDto<?>> delete(@PathVariable Long enrollmentId) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.delete(enrollmentId))
			.message("등록 정보 삭제에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
}
