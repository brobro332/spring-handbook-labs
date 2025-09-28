package com.jnbr.category.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jnbr.category.dto.CategorySaveDto;
import com.jnbr.category.dto.CategoryUpdateDto;
import com.jnbr.category.entity.Category;

public interface CategoryService {
	public Category save(CategorySaveDto dto);
	public Category findById(Long catId);
	public Page<Category> findAll(Pageable pageable);
	public Category update(Long catId, CategoryUpdateDto dto);
	public Category delete(Long catId);
}
