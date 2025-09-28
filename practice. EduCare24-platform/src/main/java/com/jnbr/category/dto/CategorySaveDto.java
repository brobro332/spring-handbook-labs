package com.jnbr.category.dto;

import com.jnbr.category.entity.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategorySaveDto {
	private String catName;
	
	public Category toEntity() {
		return Category.builder()
			.catName(this.catName)
			.build();
	}
}
