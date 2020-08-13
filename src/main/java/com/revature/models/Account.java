package com.revature.models;

import java.util.ArrayList;

public class Account {

	private String type; //name of the account type
	private String id;
	private User owner; //owner is the user object who owns the account
	private ArrayList <Transaction> transactions; //list of transactions for the account
	private String accountStatus;

	//account constructor
	public Account(String type, User owner, String accountStatus, Bank myBank) {
		
		//set the account type and owner
		this.type = type;
		this.owner = owner;
		
		//initialize transactions into an empty array list
		this.transactions = new ArrayList<Transaction>();
		
	}

	public Account() {
		super();
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [type=" + type + ", id=" + id + ", owner=" + owner + ", transactions=" + transactions
				+ ", accountStatus=" + accountStatus + "]";
	}

	}
	
