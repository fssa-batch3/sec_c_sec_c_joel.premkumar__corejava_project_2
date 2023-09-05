package com.fssa.stockmanagementapp.model;

public class User {
	private String fullName;
	private String emailId;
	private long phoneNumber;
	private String password;
	private boolean isActive;


	public User() {
	}
	
	public User(String fullName, String emailId, Long phoneNumber, String password) {
		this.fullName = fullName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	public User(String fullName, String emailId, Long phoneNumber, String password, boolean isActive) {
		this.fullName = fullName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.isActive = isActive;
	}

	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", password="
				+ password + ", isActive=" + isActive + "]";
	}

}



