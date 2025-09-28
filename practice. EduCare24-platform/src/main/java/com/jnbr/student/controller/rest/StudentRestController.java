package com.jnbr.student.controller.rest;

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
import com.jnbr.student.dto.StudentSaveDto;
import com.jnbr.student.dto.StudentUpdateDto;
import com.jnbr.student.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentRestController {
	private final StudentService service;
	
	@PostMapping
	public ResponseEntity<CommonResponseDto<?>> save(@RequestBody StudentSaveDto dto) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.save(dto))
			.message("학생 정보 등록에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<CommonResponseDto<?>> findById(@PathVariable Long studentId) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.findById(studentId))
			.message("학생 단일 목록 조회에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@GetMapping("/all")
	public ResponseEntity<CommonResponseDto<?>> findAll(@PageableDefault(size = 5, page = 0) Pageable pageable) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.findAll(pageable))
			.message("학생 전체 목록 조회에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@PutMapping("/{studentId}")
	public ResponseEntity<CommonResponseDto<?>> update(@PathVariable Long studentId, @RequestBody StudentUpdateDto dto) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.update(studentId, dto))
			.message("학생 정보 수정에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<CommonResponseDto<?>> delete(@PathVariable Long studentId) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.delete(studentId))
			.message("학생 정보 삭제에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
}
