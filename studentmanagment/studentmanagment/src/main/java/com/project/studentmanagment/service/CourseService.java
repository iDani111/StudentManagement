package com.project.studentmanagment.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.studentmanagment.entity.Course;
import com.project.studentmanagment.entity.Student;

@Repository
public interface CourseService extends JpaRepository<Course,Long> {
	

	public Course findByTxtCourseName(String courseName);
}
