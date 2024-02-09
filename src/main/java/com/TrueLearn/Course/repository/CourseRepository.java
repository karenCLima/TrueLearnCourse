package com.TrueLearn.Course.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.TrueLearn.Course.model.Course;
import com.TrueLearn.Course.model.CourseCategory;


public interface CourseRepository extends JpaRepository<Course, Long> {
	
	@Query(value = "SELECT * FROM COURSES WHERE COURSE_ID = :courseId", nativeQuery = true)
    Course findByCourseIdCourse(UUID courseId);
	
	@Query(value = "SELECT * FROM COURSES WHERE CATEGORY = :courseCategory", nativeQuery = true)
    List<Course> findByCourseCategory(CourseCategory courseCategory);
	
	@Query(value = "SELECT * FROM COURSES WHERE INSTRUCTOR = :instructor", nativeQuery = true)
    List<Course> findByInstructor(String instructor);

}
