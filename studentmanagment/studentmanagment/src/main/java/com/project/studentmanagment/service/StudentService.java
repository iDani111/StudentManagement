package com.project.studentmanagment.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.studentmanagment.entity.Student;

@Repository
public interface StudentService extends JpaRepository<Student,Long> {

}
