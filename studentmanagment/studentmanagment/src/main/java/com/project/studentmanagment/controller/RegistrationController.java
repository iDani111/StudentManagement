package com.project.studentmanagment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.studentmanagment.entity.Course;
import com.project.studentmanagment.entity.Student;
import com.project.studentmanagment.entity.StudentCourseRegistration;
import com.project.studentmanagment.service.CourseService;
import com.project.studentmanagment.service.RegistrationService;
import com.project.studentmanagment.service.StudentService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private StudentService studentservice;
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping(path="/courseregistration/{serStudentId}/{serCourseId}")
	public String makeNewCourse(
			
			@PathVariable Long serStudentId,@PathVariable Long serCourseId) throws Exception{
		
			StudentCourseRegistration reg=new StudentCourseRegistration();
		
		
		
			if(serStudentId!=null && !serStudentId.equals("")) {
			
			Student student=	studentservice.findById(serStudentId).get();
			
			if(student!=null) {
			reg.setSerStudentId(student.getSerStudentId());
			}	
			
			else {
				
				throw new Exception("Invalid Student ID");
			}
				
			}
			else {
				
				throw new Exception("Student ID not found");
			}
			
			
			if(serCourseId!=null && !serCourseId.equals("")) {
				
				Course course=	courseService.findById(serCourseId).get();
						
						if(course!=null) {
						reg.setSerCourseId(course.getSerCourseId());
						}	
						
						else {
							
							throw new Exception("Invalid Course ID");
						}
				
			}
			else {
				
				throw new Exception("Course ID not found");
			}
			
			reg.setBlnActive(true);
			StudentCourseRegistration registerCourse=registrationService.save(reg);
		
			if(registerCourse!=null) {
			return "Student Register Course successfully.";
			}
			else {
				
				return "Error!!!";

			}
		
	}
	
	
	
	@GetMapping("/registration/viewregistercourse/{serstudentid}")
	public List<StudentCourseRegistration> viewRegisterCourses(@PathVariable Long serstudentid) throws Exception{
	
	if(serstudentid==null || serstudentid.equals("")) {
		
		
		throw new Exception("Add Student Id In Path Variable to check register Courses by student");
	}
		
		
	if(registrationService.findBySerStudentId(serstudentid)!=null) {
	return registrationService.findBySerStudentId(serstudentid);
	}
	else {
		return null;
		
	}
	}
	
	
	@GetMapping("/registration/viewallregistercourses")
	public List<StudentCourseRegistration> viewAllRegisterCourses(){

	if(registrationService.findAll()!=null) {
	return registrationService.findAll();
	}
	else {
		return null;
		
	}
	}
	
	
	
	
	@DeleteMapping("/registration/deletecourse/{serregistrationid}")
	public String deleteCourse(@PathVariable Long serregistrationid){

		registrationService.deleteById(serregistrationid);
		
		return "Course Enroll Successfully.";
	}
	

}
