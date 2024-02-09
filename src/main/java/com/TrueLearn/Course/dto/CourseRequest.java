package com.TrueLearn.Course.dto;

import java.math.BigDecimal;


import org.hibernate.validator.constraints.Length;

import com.TrueLearn.Course.model.CourseCategory;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class CourseRequest {
	
	@NotEmpty @Length(min = 4)
	private String name;
	
	@NotNull
	private CourseCategory courseCategory;
	
	@NotEmpty  @Length(min = 4)
	private String instructor;
	
	private String description;
	
	@NotNull 
	private BigDecimal price;
	
	@NotNull
	private Integer workload;
	
}
