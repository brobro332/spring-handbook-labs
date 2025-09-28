package com.jnbr.category.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TBL_CATEGORY")
@SequenceGenerator(
	name = "SEQ_CATEGORY_GEN",
	sequenceName = "SEQ_CATEGORY",
	initialValue = 1,
	allocationSize = 1
)
public class Category {
	@Id
	@GeneratedValue(generator = "SEQ_CATEGORY_GEN", strategy = GenerationType.SEQUENCE)
	private Long catId;
	
	@Column(length = 50, nullable = false)
	private String catName;
	
	public void updateCatName(String catName) {
		this.catName = catName;
	}
}
