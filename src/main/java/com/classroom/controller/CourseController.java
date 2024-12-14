package com.classroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classroom.entity.Course;
import com.classroom.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/getAll")
	public List<Course> getAllCourses() {
		return courseService.getallCourse();
	}

	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable Long id) {
		return courseService.getCourseById(id);
	}

	@PostMapping("/insertcourse")
	public Course createCourse(@RequestBody Course course) {
		courseService.createCourse(course);
		return course;
	}

	@PutMapping("/{id}")
	public Course updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
		Course course = courseService.getCourseById(id);
		if (course != null) {
			course.setName(courseDetails.getName());
			courseService.updateCourse(course);
		}
		return course;
	}

	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);
	}
}
