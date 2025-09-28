package com.jnbr.category.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.jnbr.category.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	Page<Category> findAll(Pageable pageable);
}
