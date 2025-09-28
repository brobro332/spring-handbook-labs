package com.jnbr.common.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(basePackages = {
	"com.jnbr.student.controller.mvc",	
	"com.jnbr.category.controller.mvc",
	"com.jnbr.course.controller.mvc",
	"com.jnbr.enrollment.controller.mvc"
})
@Slf4j
public class CommonAdvice {
	@ExceptionHandler(EntityNotFoundException.class)
	public String handleException(EntityNotFoundException e, Model model) {
		log.warn(e.getClass().getName() + " | " + e.getMessage() + " | " + e.getCause());
		
		model.addAttribute("error", "요청하신 " + e.getMessage() + " 데이터가 존재하지 않습니다. 다시 시도해주세요.");
		
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		log.warn(e.getClass().getName() + " | " + e.getMessage() + " | " + e.getCause());
		
		model.addAttribute("error", "서버 내부 오류가 발생했습니다. 관리자에게 문의해주세요.");
		
		return "error";
	}
}
