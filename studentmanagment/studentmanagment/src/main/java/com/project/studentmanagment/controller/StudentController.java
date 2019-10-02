package com.project.studentmanagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.studentmanagment.entity.AdminTblCodePattern;
import com.project.studentmanagment.entity.Student;
import com.project.studentmanagment.service.AdminTblCodePatternService;
import com.project.studentmanagment.service.StudentService;


@RestController
public class StudentController {
	
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AdminTblCodePatternService adminTblCodePatternService;
	
	@Autowired
	private UsersController userController;
	
	@GetMapping("/student/viewallstudents")
	public List<Student> viewAllStudents(){

	if(studentService.findAll()!=null) {
	
	return studentService.findAll();
	}
	else {
		return null;
		
	}
	}

	
	@PostMapping(path="/student")
	public String makeNewStudent(@RequestBody Student student) throws Exception{
		
		try {
		AdminTblCodePattern  adminTblCodePattern=
		         adminTblCodePatternService.findByTxtCodePatternForAndIsActive("student", true);
		
		if(student!=null) {
		if(adminTblCodePattern!=null) {
			
		if(adminTblCodePattern.getTxtCodePattern()!=null) {
				
		student.setTxtStudentCode(adminTblCodePattern.getTxtCodePattern()+"-"+adminTblCodePattern.getNumLastKeyValue());
			
		Student createdStudent=studentService.save(student);
		
		userController.incrementCodePattern("student");
		
		String message =userController.makeNewUsers(createdStudent);
		

	
			return message;
	
		}
		}else
		{
			
			throw new Exception("Student Code is not configure");
		}
		
		}
		else {
			
			throw new Exception("Invalid Data");

		}
		
		}
		catch(MethodArgumentNotValidException  ex) {
			
			return ex.getMessage();
		}
		
		return null;
		


	}
	
	

}
