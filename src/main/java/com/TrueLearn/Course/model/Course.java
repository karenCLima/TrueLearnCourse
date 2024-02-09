package com.TrueLearn.Course.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("deprecation")
@Entity
@Table(name="courses")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Where(clause = "active = true")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "courseId")
	private UUID courseId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "category")
	private CourseCategory courseCategory;
	
	@Column(name = "instructor")
	private String instructor;
	
	@Column(name = "description", length=512)
	private String description;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "workload")
	private Integer workload;
	
	@Column(name = "active")
	private boolean active;
	
	
}
