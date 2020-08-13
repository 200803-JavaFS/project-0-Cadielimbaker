package com.revature.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

//import java.util.Date;

public class Transaction{
	private ArrayList <User>users;
	private double amount; //amount in transaction
	//private Date time stamp;
	private String memo;
	private Account inAccount; //link back the account for which the transaction happened
	private String accountStatus;

	
public Transaction() {
		super();
	}

public Transaction(double amount, Account inAccount) {
	this.amount= amount;
	this.inAccount = inAccount;
	//this.timestamp = new Date(); //create a Date object for the current time stamp
	this.memo = ""; //set the memo
}

//overloading here
public Transaction(double amount,Account inAccount, String memo) {
	this.amount= amount;
	this.inAccount = inAccount;
	//this.timestamp = new Date(); //create a Date object for the current time stamp
	this.memo = ""; //set the memo
	}

public ArrayList<User> getUsers() {
	return users;
}

public void setUsers(ArrayList<User> users) {
	this.users = users;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public String getMemo() {
	return memo;
}

public void setMemo(String memo) {
	this.memo = memo;
}

public Account getInAccount() {
	return inAccount;
}

public void setInAccount(Account inAccount) {
	this.inAccount = inAccount;
}
//need public enum
public String getAccountStatus() {
	return accountStatus;
}

public void setAccountStatus(String accountStatus) {
	this.accountStatus = accountStatus;
}

@Override
public String toString() {
	return "Transaction [users=" + users + ", amount=" + amount + ", memo=" + memo + ", inAccount=" + inAccount
			+ ", accountStatus=" + accountStatus + "]";
}

}

