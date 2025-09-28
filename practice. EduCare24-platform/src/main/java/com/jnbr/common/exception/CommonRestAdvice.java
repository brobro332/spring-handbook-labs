package com.jnbr.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jnbr.common.dto.CommonResponseDto;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice(basePackages = {
	"com.jnbr.student.controller.rest",
	"com.jnbr.category.controller.rest",
	"com.jnbr.course.controller.rest",
	"com.jnbr.enrollment.controller.rest"
})
@Slf4j
public class CommonRestAdvice {
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<CommonResponseDto<?>> handleException(EntityNotFoundException e) {
		log.warn(e.getClass().getName() + " | " + e.getMessage() + " | " + e.getCause());
		
		Map<String, Object> error = new HashMap<>();
		error.put("status", HttpStatus.UNPROCESSABLE_ENTITY.value());
		error.put("code", HttpStatus.UNPROCESSABLE_ENTITY.name());
		
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(false)
			.data(null)
			.message("요청하신 " + e.getMessage() + " 데이터가 존재하지 않습니다. 다시 시도해주세요.")
			.error(error)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.UNPROCESSABLE_ENTITY)
			.body(response);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CommonResponseDto<?>> handleException(Exception e) {
		log.warn(e.getClass().getName() + " | " + e.getMessage() + " | " + e.getCause());
		
		Map<String, Object> error = new HashMap<>();
		error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.put("code", HttpStatus.INTERNAL_SERVER_ERROR.name());
		
		CommonResponseDto<?> response = CommonResponseDto.builder()
			.success(false)
			.data(null)
			.message("서버 내부 오류가 발생했습니다. 관리자에게 문의해주세요.")
			.error(error)
			.build();
		
		return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(response);
	}
}
