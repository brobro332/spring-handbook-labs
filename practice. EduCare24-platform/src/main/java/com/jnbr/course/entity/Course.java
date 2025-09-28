package com.jnbr.course.entity;

import com.jnbr.category.entity.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "TBL_COURSE")
@SequenceGenerator(
	name = "SEQ_COURSE_GEN", 
	sequenceName = "SEQ_COURSE",
	initialValue = 1,
	allocationSize = 1
)
public class Course {
	@Id
	@GeneratedValue(generator = "SEQ_COURSE_GEN", strategy = GenerationType.SEQUENCE)
	private Long courseId;
	
	@Column(length = 100, nullable = false)
	private String courseName;
	
	@Column(nullable = false)
	private Long price;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cat_id")
	private Category category;
	
	public void updateCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void updatePrice(Long price) {
		this.price = price;
	}
	
	public void updateCategory(Category category) {
		this.category = category;
	}
}
