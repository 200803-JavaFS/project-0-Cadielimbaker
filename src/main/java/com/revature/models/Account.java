	package com.revature.models;

	import java.io.Serializable;
import java.util.ArrayList;


	public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
			
	private String accountType; //name of the account type
	private int accountId;
	private int Id; //YOU NEED TO MAKE SURE THAT THIS WORKS (owner is the object of User)
	private String accountStatus;
	private double balance;
	
	public Account(String accountType, int accountId, int Id, String accountStatus, double balance) {
		super();
		this.accountType = accountType;
		this.accountId = accountId;
		this.Id = Id;
		this.accountStatus = accountStatus;
		this.balance = balance;
	}

	public Account(String accountType, int Id, String accountStatus, double balance) {
		super();
		this.accountType = accountType;
		this.Id = Id;
		this.accountStatus = accountStatus;
		this.balance = balance;
	}

	public Account() {
		super();
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + accountId;
		result = prime * result + ((accountStatus == null) ? 0 : accountStatus.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Account other = (Account) obj;
		if (Id != other.Id)
			return false;
		if (accountId != other.accountId)
			return false;
		if (accountStatus == null) {
			if (other.accountStatus != null)
				return false;
		} else if (!accountStatus.equals(other.accountStatus))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountType=" + accountType + ", accountId=" + accountId + ", Id=" + Id + ", accountStatus="
				+ accountStatus + ", balance=" + balance + "]";
	}
	
	}