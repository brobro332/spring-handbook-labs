package com.jnbr.category.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jnbr.category.dto.CategorySaveDto;
import com.jnbr.category.dto.CategoryUpdateDto;
import com.jnbr.category.entity.Category;
import com.jnbr.category.repository.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
	private final CategoryRepository repository;

	@Override
	@Transactional
	public Category save(CategorySaveDto dto) {
		return repository.save(dto.toEntity());
	}

	@Override
	public Category findById(Long catId) {
		return repository.findById(catId).orElse(null);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional
	public Category update(Long catId, CategoryUpdateDto dto) {
		Category category = findById(catId);
		
		if (category == null) throw new EntityNotFoundException("카테고리");

		category.updateCatName(dto.getCatName());
		
		return category;
	}

	@Override
	@Transactional
	public Category delete(Long catId) {
		Category category = findById(catId);
		
		if (category == null) throw new EntityNotFoundException("카테고리");

		repository.delete(category);
		
		return category;
	}
}
