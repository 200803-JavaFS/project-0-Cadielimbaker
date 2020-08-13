package com.revature.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class User {

	private String firstName;
	private String lastName;
	private String userName;
	private String id;
	//personal info
	private byte pinHash[];
	private String userType; //customer, employee, administrator
	private ArrayList <Account> accounts; //each user will have an array list of accounts they use
	
	//constructor	
	public User(String firstName, String lastName, String pin, String userType, Bank myBank) {
	
			
		//set the user's name
		this.firstName = firstName; //access firstName property using this keyword
		this.lastName = lastName;
		this.userName = userName;
		
		//create an empty list of accounts
		this.accounts = new ArrayList <Account>();
		
		//print log message to know what the id is (this print style helps with formatting)
		System.out.printf("New User %s, %s with ID %created./n ", lastName, firstName, this.id);

	}
		public User() {
		super();
	}
		//NEED to FIGURE OUT HOW TO SET PARAMETER'S FOR THE USER TYPE (Customer, Employee, Administrator)
		public String getUserType(String firstName, String lastName, String userName, String pin, String userType, Bank myBank) {
		return userType;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public byte[] getPinHash() {
		return pinHash;
	}
	public void setPinHash(byte[] pinHash) {
		this.pinHash = pinHash;
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	//know that I need to make a public enum UserType
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", pinHash="
				+ Arrays.toString(pinHash) + ", userType=" + userType + ", accounts=" + accounts + "]";
	}
	
	}

