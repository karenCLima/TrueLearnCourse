package com.TrueLearn.Course.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrueLearn.Course.dto.CourseRequest;
import com.TrueLearn.Course.dto.CourseResponse;
import com.TrueLearn.Course.model.Course;
import com.TrueLearn.Course.model.CourseCategory;
import com.TrueLearn.Course.repository.CourseRepository;
import com.TrueLearn.Course.util.CourseConvert;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public CourseResponse save(CourseRequest courseRequest) {
		Course course = CourseConvert.toEntity(courseRequest);
		course.setCourseId(UUID.randomUUID());
		if(course.getCourseCategory() == CourseCategory.CHEMISTRY || course.getCourseCategory() == CourseCategory.ENGENEERING || course.getCourseCategory() == CourseCategory.TECHNOLOGY || course.getCourseCategory() == CourseCategory.SCIENCE) {
			if(course.getPrice().compareTo(BigDecimal.valueOf(50.0))< 0) throw new RuntimeException("The min value to this category is 50.0");
		}else if(course.getCourseCategory() == CourseCategory.BUSSINESS || course.getCourseCategory() == CourseCategory.HEALTH) {
			if(course.getPrice().compareTo(BigDecimal.valueOf(30.0))<0) throw new RuntimeException("The min value to this category is 30.0");
		}
		course.setActive(true);
		
		return CourseConvert.toResponse(courseRepository.save(course));
		
	}
	
	public List<CourseResponse> getAll(){
		List<Course> courses = courseRepository.findAll();
		return CourseConvert.toResponseList(courses);
	}
	
	public CourseResponse getCourseByCourseId(UUID courseId) {
		Course existCourse = courseRepository.findByCourseIdCourse(courseId);
		if(existCourse == null) throw new RuntimeException("Course not found!");
		return CourseConvert.toResponse(existCourse);
	}
	
	public void delete(UUID courseId) {
		Course existCourse = courseRepository.findByCourseIdCourse(courseId);
		if(existCourse == null) throw new RuntimeException("Course not found!");
		existCourse.setActive(false);
		courseRepository.save(existCourse);
	}
	
	public CourseResponse update(CourseRequest courseRequest, UUID courseId) {
		Course course = CourseConvert.toEntity(courseRequest);
		Course existCourse = courseRepository.findByCourseIdCourse(courseId);
		if(existCourse == null) throw new RuntimeException("Course not found!");
		if(course.getCourseCategory() == CourseCategory.CHEMISTRY || course.getCourseCategory() == CourseCategory.ENGENEERING || course.getCourseCategory() == CourseCategory.TECHNOLOGY || course.getCourseCategory() == CourseCategory.SCIENCE) {
			if(course.getPrice().compareTo(BigDecimal.valueOf(50.0))< 0) throw new RuntimeException("The min value to this category is 50.0");
		}else if(course.getCourseCategory() == CourseCategory.BUSSINESS || course.getCourseCategory() == CourseCategory.HEALTH) {
			if(course.getPrice().compareTo(BigDecimal.valueOf(30.0))<0) throw new RuntimeException("The min value to this category is 30.0");
		}
		course.setCourseId(courseId);
		course.setId(existCourse.getId());
		course.setActive(true);
		
		return CourseConvert.toResponse(courseRepository.save(course));
	}
	
	public List<CourseResponse> getCourseByCategory(CourseCategory courseCategory){
		List<Course> courses = courseRepository.findByCourseCategory(courseCategory);
		return CourseConvert.toResponseList(courses);
	}
	
	public List<CourseResponse> getCourseByInstructor(String instructor){
		List<Course> courses = courseRepository.findByInstructor(instructor);
		return CourseConvert.toResponseList(courses);
	}


}
