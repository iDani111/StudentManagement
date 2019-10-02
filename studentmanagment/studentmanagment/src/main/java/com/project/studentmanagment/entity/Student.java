package com.project.studentmanagment.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="student_information")
public class Student {
	
	@Id
	@GeneratedValue
	private Long serStudentId;
	
	@NotNull(message = "Student Code cannot be null")
	private String txtStudentCode;
	@NotNull(message = "Student First Name cannot be null")
	private String txtFirstName;
	private String txtLastName;
	private Boolean blnActive;
	
    @OneToMany(mappedBy = "student")
    Set<StudentCourseRegistration> registrations;
	
	public Long getSerStudentId() {
		return serStudentId;
	}
	public void setSerStudentId(Long serStudentId) {
		this.serStudentId = serStudentId;
	}
	public String getTxtStudentCode() {
		return txtStudentCode;
	}
	public void setTxtStudentCode(String txtStudentCode) {
		this.txtStudentCode = txtStudentCode;
	}
	public String getTxtFirstName() {
		return txtFirstName;
	}
	public void setTxtFirstName(String txtFirstName) {
		this.txtFirstName = txtFirstName;
	}
	public String getTxtLastName() {
		return txtLastName;
	}
	public void setTxtLastName(String txtLastName) {
		this.txtLastName = txtLastName;
	}
	public Boolean getBlnActive() {
		return blnActive;
	}
	public void setBlnActive(Boolean blnActive) {
		this.blnActive = blnActive;
	}
	
	public Set<StudentCourseRegistration> getRegistrations() {
		return registrations;
	}
	public void setRegistrations(Set<StudentCourseRegistration> registrations) {
		this.registrations = registrations;
	}
	
	public Student() {}
	
	public Student(Long serStudentId, String txtStudentCode, String txtFirstName, String txtLastName,
			Boolean blnActive) {
		super();
		this.serStudentId = serStudentId;
		this.txtStudentCode = txtStudentCode;
		this.txtFirstName = txtFirstName;
		this.txtLastName = txtLastName;
		this.blnActive = blnActive;
	}
	
	
	@Override
	public String toString() {
		return "Student [serStudentId=" + serStudentId + ", txtStudentCode=" + txtStudentCode + ", txtFirstName="
				+ txtFirstName + ", txtLastName=" + txtLastName + ", blnActive=" + blnActive + "]";
	}
	
	
	

}
