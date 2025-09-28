package com.jnbr.course.controller.mvc;

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

import com.jnbr.course.dto.CourseSaveDto;
import com.jnbr.course.dto.CourseUpdateDto;
import com.jnbr.course.entity.Course;
import com.jnbr.course.service.CourseService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
	private final CourseService service;
	
	/* 1. Navigate Method */
	
	@GetMapping
	public String navigateMainPage() {
		return "course/index";
	}
	
	@GetMapping("/find-by-id")
	public String navigateFindByIdPage() {
		return "course/find-by-id";
	}
	
	@GetMapping("/save")
	public String navigateSavePage() {
		return "course/save";
	}
	
	@GetMapping("/update/{courseId}")
	public String navigateUpdatePage(@PathVariable Long courseId, Model model) {
		Course course = service.findEntityById(courseId);
		
		model.addAttribute("course", course);
		
		return "course/update";
	}
	
	@GetMapping("/delete/{courseId}")
	public String navigateDeletePage(@PathVariable Long courseId, Model model) {
		Course course = service.findEntityById(courseId);
		
		model.addAttribute("course", course);
		
		return "course/delete";
	}
	
	/* 2. Processing Method */
	
	@PostMapping
	public String save(@ModelAttribute CourseSaveDto dto) {
		service.save(dto);
		
		return "course/index";
	}
	
	@GetMapping("/one")
	public String findById(@RequestParam Long courseId, Model model) {
		model.addAttribute("course", service.findById(courseId));
		
		return "course/find-by-id-result";
	}
	
	@GetMapping("/all")
	public String findAll(@PageableDefault(size = 5, page = 0) Pageable pageable, Model model) {
		Page<Course> coursePage = service.findAllWithCategory(pageable);
		
		model.addAttribute("coursePage", coursePage);
		
		return "course/find-all";
	}
	
	@PostMapping("/update/{courseId}")
	public String update(@PathVariable Long courseId, @ModelAttribute CourseUpdateDto dto, Model model) {
		service.update(courseId, dto);
		
		return "redirect:/course";
	}
	
	@PostMapping("/delete/{courseId}")
	public String delete(@PathVariable Long courseId) {
		service.delete(courseId);
		
		return "redirect:/course";
	}
}
