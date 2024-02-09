package com.TrueLearn.Course.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TrueLearn.Course.dto.CourseRequest;
import com.TrueLearn.Course.dto.CourseResponse;
import com.TrueLearn.Course.model.CourseCategory;
import com.TrueLearn.Course.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping()
	public ResponseEntity<CourseResponse> saveCourse(@RequestBody @Valid CourseRequest courseRequest){
		CourseResponse courseResponse = courseService.save(courseRequest);
		return ResponseEntity.created(URI.create("/user/"+courseResponse.getCourseId())).body(courseResponse);
	}
	
	@GetMapping()
	public ResponseEntity<List<CourseResponse>> getAllCourses(){
		return ResponseEntity.ok(courseService.getAll());
	}
	
	@DeleteMapping("/{courseId}")
	public void deleteCourse(@PathVariable UUID courseId) {
		courseService.delete(courseId);
	}
	
	@PutMapping("/{courseId}")
	public ResponseEntity<CourseResponse> updateCourse(@RequestBody CourseRequest courseRequest, @PathVariable UUID courseId){
		return ResponseEntity.ok(courseService.update(courseRequest, courseId));
	}
	
	@GetMapping("/find/{courseId}")
	public ResponseEntity<CourseResponse> getCourseByCourseId(@PathVariable UUID courseId){
		return ResponseEntity.ok(courseService.getCourseByCourseId(courseId));
	}
	
	@GetMapping("/category/{courseCategory}")
	public ResponseEntity<List<CourseResponse>> getCoursesByCategory(@PathVariable CourseCategory courseCategory){
		return ResponseEntity.ok(courseService.getCourseByCategory(courseCategory));
	}
	
	@GetMapping("/instructor/{instructor}")
	public ResponseEntity<List<CourseResponse>> getCoursesByInstructor(@PathVariable String instructor){
		return ResponseEntity.ok(courseService.getCourseByInstructor(instructor));
	}
}
