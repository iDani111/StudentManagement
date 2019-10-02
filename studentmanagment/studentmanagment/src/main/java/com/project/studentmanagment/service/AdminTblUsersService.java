package com.project.studentmanagment.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.studentmanagment.entity.AdminTblUsers;

@Repository
public interface AdminTblUsersService extends JpaRepository<AdminTblUsers,Long> {
	
	public AdminTblUsers findByTxtUserNameAndTxtPassword(String userName,String password);

}
