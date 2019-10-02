package com.project.studentmanagment.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.studentmanagment.entity.AdminTblCodePattern;

@Repository
public interface AdminTblCodePatternService extends JpaRepository<AdminTblCodePattern, Long>{
	
	
	AdminTblCodePattern findByTxtCodePatternForAndIsActive(String txtCodePatternFor, Boolean isActive);

}
