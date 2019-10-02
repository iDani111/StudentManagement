package com.project.studentmanagment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="admin_tbl_code_pattern")
public class AdminTblCodePattern {
	
	@Id
	@GeneratedValue
	private Long serPatternId;
	private String txtCodePatternFor;
	private String txtCodePattern;
	private Long numLastKeyValue;
	private Boolean isActive;
	
	public Long getSerPatternId() {
		return serPatternId;
	}
	public void setSerPatternId(Long serPatternId) {
		this.serPatternId = serPatternId;
	}
	public String getTxtCodePatternFor() {
		return txtCodePatternFor;
	}
	public void setTxtCodePatternFor(String txtCodePatternFor) {
		this.txtCodePatternFor = txtCodePatternFor;
	}
	public String getTxtCodePattern() {
		return txtCodePattern;
	}
	public void setTxtCodePattern(String txtCodePattern) {
		this.txtCodePattern = txtCodePattern;
	}
	public Long getNumLastKeyValue() {
		return numLastKeyValue;
	}
	public void setNumLastKeyValue(Long numLastKeyValue) {
		this.numLastKeyValue = numLastKeyValue;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public AdminTblCodePattern() {}
	
	public AdminTblCodePattern(Long serPatternId, String txtCodePatternFor, String txtCodePattern, Long numLastKeyValue,
			Boolean isActive) {
		super();
		this.serPatternId = serPatternId;
		this.txtCodePatternFor = txtCodePatternFor;
		this.txtCodePattern = txtCodePattern;
		this.numLastKeyValue = numLastKeyValue;
		this.isActive = isActive;
	}
	
	
	@Override
	public String toString() {
		return "AdminTblCodePattern [serPatternId=" + serPatternId + ", txtCodePatternFor=" + txtCodePatternFor
				+ ", txtCodePattern=" + txtCodePattern + ", numLastKeyValue=" + numLastKeyValue + ", isActive="
				+ isActive + "]";
	}
	
	
	
	

}
