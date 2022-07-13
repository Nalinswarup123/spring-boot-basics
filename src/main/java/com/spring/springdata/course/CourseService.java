package com.spring.springdata.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springdata.topic.Topic;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	private int newId = 1;
	
	public Course getCourse(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Course> getAllCourses(int topicId) {
		List<Course> courses = new ArrayList<>();
		repository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public void createCourse(Course course) {
		course.setId(newId++);
		repository.save(course);
	}
	
	public void updateCourse(Course course) {
		repository.save(course);
	}
	
	public void deleteCourse(int id) {
		repository.deleteById(id);
	}
}
