package com.TrueLearn.Course.util;

import java.util.List;
import java.util.ArrayList;

import com.TrueLearn.Course.dto.CourseRequest;
import com.TrueLearn.Course.dto.CourseResponse;
import com.TrueLearn.Course.model.Course;

public class CourseConvert {
	
	public static Course toEntity(CourseRequest courseRequest) {
		Course course = new Course();
		course.setCourseCategory(courseRequest.getCourseCategory());
		course.setDescription(courseRequest.getDescription());
		course.setInstructor(courseRequest.getInstructor());
		course.setName(courseRequest.getName());
		course.setPrice(courseRequest.getPrice());
		course.setWorkload(courseRequest.getWorkload());
		
		return course;
	}
	
	public static CourseResponse toResponse(Course course) {
		CourseResponse courseResponse = new CourseResponse();
		courseResponse.setId(course.getId());
		courseResponse.setName(course.getName());
		courseResponse.setCourseCategory(course.getCourseCategory());
		courseResponse.setCourseId(course.getCourseId());
		courseResponse.setDescription(course.getDescription());
		courseResponse.setInstructor(course.getInstructor());
		courseResponse.setPrice(course.getPrice());
		courseResponse.setWorkload(course.getWorkload());
		
		return courseResponse;
	}
	
	public static List<CourseResponse> toResponseList(List<Course> courses){
		List<CourseResponse> courseResponses = new ArrayList<>();
		for (Course course : courses) {
			CourseResponse courseResponse = CourseConvert.toResponse(course);
			courseResponses.add(courseResponse);
		}
		return courseResponses;
	}

}
