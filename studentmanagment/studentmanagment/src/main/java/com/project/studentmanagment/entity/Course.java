package com.project.studentmanagment.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="course_information")
public class Course {
	
	@Id
	@GeneratedValue
	private Long serCourseId;
	private String txtCourseCode;
	private String txtCourseName;
	private Double numCreditHours;
	private Boolean blnActive;
	
    @OneToMany(mappedBy = "course")
    Set<StudentCourseRegistration> registrations;


	public Long getSerCourseId() {
		return serCourseId;
	}
	public void setSerCourseId(Long serCourseId) {
		this.serCourseId = serCourseId;
	}
	public String getTxtCourseCode() {
		return txtCourseCode;
	}
	public void setTxtCourseCode(String txtCourseCode) {
		this.txtCourseCode = txtCourseCode;
	}
	public String getTxtCourseName() {
		return txtCourseName;
	}
	public void setTxtCourseName(String txtCourseName) {
		this.txtCourseName = txtCourseName;
	}
	public Double getNumCreditHours() {
		return numCreditHours;
	}
	public void setNumCreditHours(Double numCreditHours) {
		this.numCreditHours = numCreditHours;
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
	
	public Course() {}
	
	public Course(Long serCourseId, String txtCourseCode, String txtCourseName, Double numCreditHours,
			Boolean blnActive) {
		super();
		this.serCourseId = serCourseId;
		this.txtCourseCode = txtCourseCode;
		this.txtCourseName = txtCourseName;
		this.numCreditHours = numCreditHours;
		this.blnActive = blnActive;
	}
	
	@Override
	public String toString() {
		return "Course [serCourseId=" + serCourseId + ", txtCourseCode=" + txtCourseCode + ", txtCourseName="
				+ txtCourseName + ", numCreditHours=" + numCreditHours + ", blnActive=" + blnActive + "]";
	}
	
	
	

}
