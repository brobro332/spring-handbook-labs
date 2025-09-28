package com.jnbr.category.dto;

import com.jnbr.category.entity.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryResponseDto {
	private Long catId;
	private String catName;
	
	public CategoryResponseDto(Category category) {
		this.catId = category.getCatId();
		this.catName = category.getCatName();
	}
}
