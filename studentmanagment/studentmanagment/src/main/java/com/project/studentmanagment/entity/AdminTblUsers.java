package com.project.studentmanagment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_tbl_users")
public class AdminTblUsers {

	@Id
	@GeneratedValue
	private Long serUserId;
	private String txtUserName;
	private String txtPassword;
	private Long serStudentId;
	private Boolean blnActive;
	public Long getSerUserId() {
		return serUserId;
	}
	public void setSerUserId(Long serUserId) {
		this.serUserId = serUserId;
	}
	public String getTxtUserName() {
		return txtUserName;
	}
	public void setTxtUserName(String txtUserName) {
		this.txtUserName = txtUserName;
	}
	public String getTxtPassword() {
		return txtPassword;
	}
	public void setTxtPassword(String txtPassword) {
		this.txtPassword = txtPassword;
	}
	public Long getSerStudentId() {
		return serStudentId;
	}
	public void setSerStudentId(Long serStudentId) {
		this.serStudentId = serStudentId;
	}
	public Boolean getBlnActive() {
		return blnActive;
	}
	public void setBlnActive(Boolean blnActive) {
		this.blnActive = blnActive;
	}
	
	public AdminTblUsers() {}
	
	public AdminTblUsers(Long serUserId, String txtUserName, String txtPassword, Long serStudentId, Boolean blnActive) {
		super();
		this.serUserId = serUserId;
		this.txtUserName = txtUserName;
		this.txtPassword = txtPassword;
		this.serStudentId = serStudentId;
		this.blnActive = blnActive;
	}
	
	
	@Override
	public String toString() {
		return "AdminTblUsers [serUserId=" + serUserId + ", txtUserName=" + txtUserName + ", txtPassword=" + txtPassword
				+ ", serStudentId=" + serStudentId + ", blnActive=" + blnActive + "]";
	}
	
	
	
	
}
