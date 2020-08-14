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
	private String Id;
	private int phoneNumber;
	private byte pinHash[];
	private USERTYPE userType; //customer, employee, administrator
	private ArrayList <Account> accounts; //each user will have an array list of accounts they use
	
		
	public User(String firstName, String lastName, String userName, String id, int phoneNumber, byte[] pinHash,
			USERTYPE userType, ArrayList<Account> accounts, String Id) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.Id = Id;
	this.phoneNumber = phoneNumber;
	this.pinHash = pinHash;
	this.userType = userType;
	this.accounts = accounts;
	//create an empty list of accounts
	this.accounts = new ArrayList <Account>();
	}
	
	//remove Id for serialization purposes
	public User(String firstName, String lastName, String userName, int phoneNumber, byte[] pinHash,
			USERTYPE userType, ArrayList<Account> accounts, String Id) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.phoneNumber = phoneNumber;
	this.pinHash = pinHash;
	this.userType = userType;
	this.accounts = accounts;
	//create an empty list of accounts
	this.accounts = new ArrayList <Account>();
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
	
	public String getAccountId() {
		return Id;
	}
	
	public void setId(String Id) {
		this.Id = Id;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	
	//enumerator for user type 
	public USERTYPE getUserType() {
		return userType;
	}
	
	//enumerator for user type
	public void setUserType(USERTYPE userType) {
		this.userType = userType;
	}
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", id=" + Id + ", pinHash="
				+ Arrays.toString(pinHash) + ", userType=" + userType + ", accounts=" + accounts + "]";
	}
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}
	
	}

