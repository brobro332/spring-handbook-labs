package com.jnbr.student.controller.mvc;

import org.springframework.data.domain.Page;
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

import com.jnbr.student.dto.StudentSaveDto;
import com.jnbr.student.dto.StudentUpdateDto;
import com.jnbr.student.entity.Student;
import com.jnbr.student.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
	private final StudentService service;
	
	/* 1. Navigate Method */
	
	@GetMapping
	public String navigateMainPage() {
		return "student/index";
	}
	
	@GetMapping("/save")
	public String navigateSavePage() {
		return "student/save";
	}
	
	@GetMapping("/find-by-id")
	public String navigateFindByIdPage() {
		return "student/find-by-id";
	}
	
	@GetMapping("/update/{studentId}")
	public String navigateUpdatePage(@PathVariable Long studentId, Model model) {
		model.addAttribute("student", service.findById(studentId));
		
		return "student/update";
	}
	
	@GetMapping("/delete/{studentId}")
	public String navigateDeletePage(@PathVariable Long studentId, Model model) {
		model.addAttribute("student", service.findById(studentId));
		
		return "student/delete";
	}
	
	/* 2. Processing Method */
	
	@PostMapping
	public String save(@ModelAttribute StudentSaveDto dto) {
		service.save(dto);
		
		return "student/index";
	}
	
	@GetMapping("/one")
	public String findById(@RequestParam Long studentId, Model model) {
		model.addAttribute("student", service.findById(studentId));
		
		return "student/find-by-id-result";
	}
	
	@GetMapping("/all")
	public String findAll(@PageableDefault(size = 5, page = 0) Pageable pageable, Model model) {
		Page<Student> studentPage = service.findAll(pageable);
		
		int buttonsPerPage = 5;
	    int startPage = (studentPage.getNumber() / buttonsPerPage) * buttonsPerPage;
	    int endPage = Math.min(startPage + buttonsPerPage - 1, studentPage.getTotalPages() - 1);
	    
		model.addAttribute("studentPage", studentPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "student/find-all";
	}
	
	@PostMapping("/update/{studentId}")
	public String update(@PathVariable Long studentId, @ModelAttribute StudentUpdateDto dto, Model model) {
		service.update(studentId, dto);
		
		return "redirect:/student";
	}
	
	@PostMapping("/delete/{studentId}")
	public String delete(@PathVariable Long studentId) {
		service.delete(studentId);
		
		return "redirect:/student";
	}
}
