package com.jnbr.category.controller.mvc;


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

import com.jnbr.category.dto.CategorySaveDto;
import com.jnbr.category.dto.CategoryUpdateDto;
import com.jnbr.category.entity.Category;
import com.jnbr.category.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
	private final CategoryService service;
	
	/* 1. Navigate Method */
	
	@GetMapping
	public String navigateMainPage() {
		return "category/index";
	}
	
	@GetMapping("/save")
	public String navigateSavePage() {
		return "category/save";
	}
	
	@GetMapping("/find-by-id")
	public String navigateFindByIdPage() {
		return "category/find-by-id";
	}
	
	@GetMapping("/update/{catId}")
	public String navigateUpdatePage(@PathVariable Long catId, Model model) {
		model.addAttribute("category", service.findById(catId));
		
		return "category/update";
	}
	
	@GetMapping("/delete/{catId}")
	public String navigateDeletePage(@PathVariable Long catId, Model model) {
		model.addAttribute("category", service.findById(catId));
		
		return "category/delete";
	}
	
	/* 2. Processing Method */
	
	@PostMapping
	public String save(@ModelAttribute CategorySaveDto dto) {
		service.save(dto);
		
		return "category/index";
	}
	
	@GetMapping("/one")
	public String findById(@RequestParam Long catId, Model model) {
		model.addAttribute("category", service.findById(catId));
		
		return "category/find-by-id-result";
	}
	
	@GetMapping("/all")
	public String findAll(@PageableDefault(size = 5, page = 0) Pageable pageable, Model model) {
		Page<Category> categoryPage = service.findAll(pageable);
		
		int buttonsPerPage = 5;
		int startPage = (categoryPage.getNumber() / buttonsPerPage) * buttonsPerPage;
		int endPage = Math.min(startPage + buttonsPerPage - 1, categoryPage.getTotalPages() - 1);
		
		model.addAttribute("categoryPage", categoryPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "category/find-all";
	}
	
	@PostMapping("/update/{catId}")
	public String update(@PathVariable Long catId, @ModelAttribute CategoryUpdateDto dto, Model model) {
		service.update(catId, dto);
		
		return "redirect:/category";
	}
	
	@PostMapping("/delete/{catId}")
	public String delete(@PathVariable Long catId) {
		service.delete(catId);
		
		return "redirect:/category";
	}
}
