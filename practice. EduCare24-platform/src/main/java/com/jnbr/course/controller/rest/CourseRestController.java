package com.jnbr.course.controller.rest;

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
import com.jnbr.course.dto.CourseSaveDto;
import com.jnbr.course.dto.CourseUpdateDto;
import com.jnbr.course.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseRestController {
	private final CourseService service;
	
	@PostMapping
	public ResponseEntity<CommonResponseDto<?>> save(@RequestBody CourseSaveDto dto) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.save(dto))
			.message("강좌 정보 등록에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@GetMapping("/{courseId}")
	public ResponseEntity<CommonResponseDto<?>> findById(@PathVariable Long courseId) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.findById(courseId))
			.message("강좌 단일 목록 조회에 성공했습니다.")
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
			.data(service.findAllWithCategory(pageable))
			.message("강좌 전체 목록 조회에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@PutMapping("/{courseId}")
	public ResponseEntity<CommonResponseDto<?>> update(@PathVariable Long courseId, @RequestBody CourseUpdateDto dto) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.update(courseId, dto))
			.message("강좌 정보 수정에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@DeleteMapping("/{courseId}")
	public ResponseEntity<CommonResponseDto<?>> delete(@PathVariable Long courseId) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.delete(courseId))
			.message("강좌 정보 삭제에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
}
