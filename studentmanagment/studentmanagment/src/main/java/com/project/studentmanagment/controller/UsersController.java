package com.project.studentmanagment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.studentmanagment.entity.AdminTblCodePattern;
import com.project.studentmanagment.entity.AdminTblUsers;
import com.project.studentmanagment.entity.Student;
import com.project.studentmanagment.service.AdminTblCodePatternService;
import com.project.studentmanagment.service.AdminTblUsersService;


@RestController
public class UsersController {
	
	@Autowired
	private AdminTblUsersService adminTblUsersService;
	
	@Autowired
	private AdminTblCodePatternService adminTblCodePatternService;
	
	
	public String makeNewUsers(Student student){
		
		if(student!=null) {
			
			if(student.getTxtStudentCode()!=null && !student.getTxtStudentCode().equals("")) {
				AdminTblUsers user=new AdminTblUsers();
				user.setTxtUserName(student.getTxtStudentCode());
				user.setSerStudentId(student.getSerStudentId());
				user.setBlnActive(true);
				String stdCode=student.getTxtStudentCode()+"12345";
		    	user.setTxtPassword(stdCode);
		    	AdminTblUsers createdUser=adminTblUsersService.save(user);
		    	
		    	return "You are registration successfully. Your bydefault user name is "+student.getTxtStudentCode()
		    	+ " and Password is "+stdCode;
			}
		}
		
		return "Error !!!";
		


	}
	
	
	
	public String incrementCodePattern(String txtCodePatternFor) {
		
		AdminTblCodePattern  adminTblCodePattern=
		         adminTblCodePatternService.findByTxtCodePatternForAndIsActive(txtCodePatternFor, true);
	
		if(adminTblCodePattern!=null) {
			
		Long modifiedLastKeyValue=adminTblCodePattern.getNumLastKeyValue()+1;
		
		adminTblCodePattern.setNumLastKeyValue(modifiedLastKeyValue);
		
		adminTblCodePatternService.save(adminTblCodePattern);
		
		return "Success";
			
		}
		
		return null;
	}
	
	
	@GetMapping("/authicateuser/{username}/{password}")
	public String userAuthicate(@PathVariable String username,@PathVariable String password) {
	
	if(username==null || username.equals("")) {
	return "Please Add User Name";
	}
	
	if(password==null || password.equals("")) {
	return "Please Add Password";
	}
	
	
	AdminTblUsers user=adminTblUsersService.findByTxtUserNameAndTxtPassword(username, password);
	
	if(user!=null) {
	
	return "user Validate Successfully.Your serStudentId is "+user.getSerStudentId() +" to Perform Operations";
	
	
	}
	else {
		
		return "Invalid Credentials";
	}
	
	}
	

}
