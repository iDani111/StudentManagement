package com.project.studentmanagment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="student_course_registration")
public class StudentCourseRegistration {
	
	@Id
	@GeneratedValue
	private Long serRegistrationId;
	private Long serStudentId;
	private Long serCourseId;
	private Boolean blnActive;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "serStudentId",insertable=false, updatable=false)
    Student student;

	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "serCourseId",insertable=false, updatable=false)
    Course course;
	
	public Long getSerRegistrationId() {
		return serRegistrationId;
	}
	public void setSerRegistrationId(Long serRegistrationId) {
		this.serRegistrationId = serRegistrationId;
	}
	
	public Long getSerStudentId() {
		return serStudentId;
	}
	public void setSerStudentId(Long serStudentId) {
		this.serStudentId = serStudentId;
	}
	public Long getSerCourseId() {
		return serCourseId;
	}
	public void setSerCourseId(Long serCourseId) {
		this.serCourseId = serCourseId;
	}
	public Boolean getBlnActive() {
		return blnActive;
	}
	public void setBlnActive(Boolean blnActive) {
		this.blnActive = blnActive;
	}
	
	
    public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	

	
	public StudentCourseRegistration() {}
	
	public StudentCourseRegistration(Long serRegistrationId, Long serStudentId, Long serCourseId, Boolean blnActive) {
		super();
		this.serRegistrationId = serRegistrationId;
		this.serStudentId = serStudentId;
		this.serCourseId = serCourseId;
		this.blnActive = blnActive;
	}
	
	
	@Override
	public String toString() {
		return "StudentCourseRegistration [serRegistrationId=" + serRegistrationId + ", serStudentId=" + serStudentId
				+ ", serCourseId=" + serCourseId + ", blnActive=" + blnActive + "]";
	}
	
	
	
	
}
