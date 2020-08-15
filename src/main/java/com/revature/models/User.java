	package com.revature.models;


	import java.io.Serializable;
//import java.security.NoSuchAlgorithmException;
	import java.util.ArrayList;
	import java.util.Arrays;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;


	public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String userName;
	private int Id;
	private int phoneNumber;
	private String password;
	private USERTYPE userType; //customer, employee, administrator
		
	public User(String firstName, String lastName, String userName, int phoneNumber, String password,
			USERTYPE userType, int Id) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.Id = Id;
	this.phoneNumber = phoneNumber;
	this.password = password;
	this.userType = userType;
	}

	//remove Id for serialization purposes
	public User(String firstName, String lastName, String userName, int phoneNumber, String password,
			USERTYPE userType) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.phoneNumber = phoneNumber;
	this.password = password;
	this.userType = userType;
	}
		public User() {
		super();
	}
	
	public String getUserName() {
			return userName;
		}
	
		public void setUserName(String userName) {
			this.userName = userName;
		}
		
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	//enumerator for user type 
	public USERTYPE getUserType() {
		return userType;
	}
	
	//enumerator for user type
	public void setUserType(USERTYPE userType) {
		this.userType = userType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + phoneNumber;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Id != other.Id)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", Id=" + Id
				+ ", phoneNumber=" + phoneNumber + ", password=" + password + ", userType=" + userType + "]";
	}
	
	}

