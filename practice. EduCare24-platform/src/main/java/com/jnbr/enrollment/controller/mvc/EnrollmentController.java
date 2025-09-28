package com.jnbr.enrollment.controller.mvc;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jnbr.enrollment.dto.EnrollmentSaveDto;
import com.jnbr.enrollment.dto.EnrollmentUpdateDto;
import com.jnbr.enrollment.entity.Enrollment;
import com.jnbr.enrollment.service.EnrollmentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {
	private final EnrollmentService service;
	
	/* 1. Navigate Method */
	
	@GetMapping
	public String navigateMainPage() {
		return "enrollment/index";
	}
	
	@GetMapping("/find-by-id")
	public String navigateFindByIdPage() {
		return "enrollment/find-by-id";
	}
	
	@GetMapping("/save")
	public String navigateSavePage() {
		return "enrollment/save";
	}
	
	@GetMapping("/update/{enrollmentId}")
	public String navigateUpdatePage(@PathVariable Long enrollmentId, Model model) {
		Enrollment enrollment = service.findEntityById(enrollmentId);
		
		model.addAttribute("enrollment", enrollment);
		
		return "enrollment/update";
	}
	
	@GetMapping("/delete/{enrollmentId}")
	public String navigateDeletePage(@PathVariable Long enrollmentId, Model model) {
		Enrollment enrollment = service.findEntityById(enrollmentId);
		
		model.addAttribute("enrollment", enrollment);
		
		return "enrollment/delete";
	}
	
	/* 2. Processing Method */
	
	@PostMapping
	public String save(@ModelAttribute EnrollmentSaveDto dto) {
		service.save(dto);
		
		return "enrollment/index";
	}
	
	@GetMapping("one")
	public String findById(@RequestParam Long enrollmentId, Model model) {
		model.addAttribute("enrollment", service.findByIdWithRelation(enrollmentId));
		
		return "enrollment/find-by-id-result";
	}
	
	@GetMapping("/all")
	public String findAll(@PageableDefault(size = 5, page = 0) Pageable pageable, Model model) {
		model.addAttribute("enrollmentPage", service.findAllWithRelation(pageable));
		
		return "enrollment/find-all";
	}
	
	@PostMapping("/update/{enrollmentId}")
	public String update(@PathVariable Long enrollmentId, @ModelAttribute EnrollmentUpdateDto dto, Model model) {
		service.update(enrollmentId, dto);
		
		return "redirect:/enrollment";
	}
	
	@PostMapping("/delete/{enrollmentId}")
	public String delete(@PathVariable Long enrollmentId) {
		service.delete(enrollmentId);
		
		return "redirect:/enrollment";
	}
}
