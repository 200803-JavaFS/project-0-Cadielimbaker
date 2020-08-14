	package com.revature.models;

	import java.io.Serializable;


	public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
			
	private String type; //name of the account type
	private String accountId;
	private User owner; //owner is the user object who owns the account
	private ACCOUNTSTATUS accountStatus;
	private double balance;
	

	public Account(String type, String accountId, User owner, String accountStatus, double balance) {
		super();
		this.type = type;
		this.accountId = accountId;
		this.owner = owner;
		this.balance = balance;
	}
	
	//remove accountId for serialization purposes
	public Account(String type, User owner, String accountStatus, double balance) {
		super();
		this.type = type;
		this.owner = owner;
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account() {
		super();
	}

	public ACCOUNTSTATUS getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(ACCOUNTSTATUS accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getaccountId() {
		return accountId;
	}

	public void setId(String accountId) {
		this.accountId = accountId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Account [type=" + type + ", accountId=" + accountId + ", owner=" + owner + ", accountStatus=" + accountStatus
				+ ", balance=" + balance + "]";
	}

}
	

	

