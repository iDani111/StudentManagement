package com.project.studentmanagment.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.studentmanagment.entity.AdminTblCodePattern;
import com.project.studentmanagment.entity.Course;
import com.project.studentmanagment.service.AdminTblCodePatternService;
import com.project.studentmanagment.service.CourseService;


@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private AdminTblCodePatternService adminTblCodePatternService;
	
	@Autowired
	private UsersController userController;
	
	@GetMapping("/course/viewallcourse")
	public List<Course> viewAllCourse(){
	
	if(courseService.findAll()!=null) {
	return courseService.findAll();
	}
	else {
		
		return null;
	}
	}

	
	
	@GetMapping("/course/searchcourse/{coursename}")
	public Course viewCourseByName(@PathVariable String coursename) throws Exception{
	
	if(coursename==null || coursename.equals("")) {
		
		throw new Exception ("Add Course Name in Path Variable");
	}	
	
	
	Course course=courseService.findByTxtCourseName(coursename);
	
	if(course!=null) {
		
		return course;
	}
	else {
		
		throw new Exception("Course Not Found");
		
	}

	}
	
	
	@PostMapping(path="/course")
	public ResponseEntity<Void> makeNewCourse(@RequestBody Course course){
		
		AdminTblCodePattern  adminTblCodePattern=
		         adminTblCodePatternService.findByTxtCodePatternForAndIsActive("course", true);
		
		if(adminTblCodePattern!=null) {
			
		if(adminTblCodePattern.getTxtCodePattern()!=null) {
		
		if(course!=null) {
		
		course.setTxtCourseCode(adminTblCodePattern.getTxtCodePattern()+"-"+adminTblCodePattern.getNumLastKeyValue());
		Course createdCourse=courseService.save(course);
		userController.incrementCodePattern("course");
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(createdCourse.getSerCourseId()).toUri();
		return ResponseEntity.created(uri).build();
		}
		
		}
		
		}
		
		return null;
	}

}
