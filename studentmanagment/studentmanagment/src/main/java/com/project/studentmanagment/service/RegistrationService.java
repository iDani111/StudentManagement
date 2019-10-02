package com.project.studentmanagment.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.studentmanagment.entity.StudentCourseRegistration;

@Repository
public interface RegistrationService extends JpaRepository<StudentCourseRegistration,Long>{

	public List<StudentCourseRegistration> findBySerStudentId(Long serStudentId);
}
