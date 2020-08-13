package com.revature.models;

import java.util.ArrayList;

import java.util.Random;

public class Bank {

	private String name;
	private ArrayList <User>users; //list of users (<Type> = <User>)
	private ArrayList <Account>accounts; //list of accounts
	
	//bank constructor
	public Bank(String name) {
		this.name = name;
		this.users = new ArrayList<User>(); //users will have an empty array list right now 
		this.accounts = new ArrayList<Account>(); //accounts array list will be empty right now
	}

	public Bank() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Bank [name=" + name + ", users=" + users + ", accounts=" + accounts + "]";
	}

}


