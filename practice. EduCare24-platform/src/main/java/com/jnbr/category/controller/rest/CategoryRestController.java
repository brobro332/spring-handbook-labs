package com.jnbr.category.controller.rest;

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

import com.jnbr.category.dto.CategorySaveDto;
import com.jnbr.category.dto.CategoryUpdateDto;
import com.jnbr.category.service.CategoryService;
import com.jnbr.common.dto.CommonResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryRestController {
	private final CategoryService service;
	
	@PostMapping
	public ResponseEntity<CommonResponseDto<?>> save(@RequestBody CategorySaveDto dto) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.save(dto))
			.message("카테고리 정보 등록에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<CommonResponseDto<?>> findById(@PathVariable Long catId) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.findById(catId))
			.message("카테고리 단일 목록 조회에 성공했습니다.")
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
			.message("카테고리 전체 목록 조회에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@PutMapping("/{catId}")
	public ResponseEntity<CommonResponseDto<?>> update(@PathVariable Long catId, @RequestBody CategoryUpdateDto dto) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.update(catId, dto))
			.message("카테고리 정보 수정에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<CommonResponseDto<?>> delete(@PathVariable Long catId) {
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(true)
			.data(service.delete(catId))
			.message("카테고리 정보 삭제에 성공했습니다.")
			.error(null)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(response);
	}
}
