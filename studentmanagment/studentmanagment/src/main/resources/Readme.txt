Student Management System

Step 1: 

-Adding Student
    
		Post request End Point http://localhost:8080/student
		
		Json Data format
		
		{

		"txtFirstName":"student first Name",
		"txtLastName":"student last Name",
		"blnActive":"true"


		}

		after Registration of student default user Name and password is provided in message to perform operation

-View All Students

		Get Request End Point :http://localhost:8080/student/viewallstudents
		

STEP-2:

			Adding Course 
			
			Post Request
			End Point http://localhost:8080/course

			Json Data Format
			
			{
			"txtCourseName":"course name",
			"numCreditHours":"4.0",
			"blnActive":"true"
	
			}
			
			
			View All Courses
			
			Get Request 
			End point http://localhost:8080/course/viewallcourse
			
			
			view course by Name
			
			Get Request 
			End point
			
			http://localhost:8080/course/searchcourse/{coursename}
			
			

Step-3

		Login to Sytem by adding default username and password providing after registration
		
		get request  

		End Point http://localhost:8080/authicateuser/{username}/{password}
		
		after authication serStudentId is Provided which is use to register course
		
		

Step-4

		register Course 
		
		
		
		get serCourseId from  Get Request 
		End point http://localhost:8080/course/viewallcourse
		
		and serStudentId Provided during regsitration
		
		Do Registration
		Post Request 
		End Point http://localhost:8080/courseregistration/{serStudentId}/{serCourseId}
		
		
		get course register by student
		
		End Point http://localhost:8080/registration/viewregistercourse/{serstudentid}
		
		
		delete enrollment 
		delete request 
		End point http://localhost:8080/registration/deletecourse/{serregistrationid}
		 
		
		



