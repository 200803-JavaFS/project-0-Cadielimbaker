package com.revature.services;
import java.util.Random;

import com.revature.models.User;
import com.revature.models.Account;

	public class AccountServices {
//NEED TO FIGURE OUT WHAT GOES HERE
	}
	
	public void deposit(int amount) {
		balance += amount;            
	}

	public boolean withdraw(int amount) {
		if( amount > balance )
			
			return false;		// unsuccessful
		
		balance -= amount;		// successful
		
		return true;
	}

	public void closeAccount() {
		balance = 0;
		setAccountStatus("closed");
}

	
	//create a new account (SAVINGS OR CHECKINGS)
	Account newAccount = new Account(type, owner, ACCOUNTSTATUS, this);
	USERTYPE.addAccount(newAccount);
	this.addAccount(newAccount);
	
	return owner;
	return USERTYPE.userName;
}

//method for new account id
public String getNewAccountID() {
	
	String id; //initialize the id string
	Random rng = new Random();
	int len= 6;
	boolean nonUnique = false;
	
	do {
		id= "";
		for(int i = 0; i<len; i++) {
			id+=((Integer)rng.nextInt(10)).toString();
			
			//check for uniqueness
			nonUnique = false;
			for(Account a: this.accounts) {
				if(id.compareTo(a.getaccountId())==0) {
					nonUnique=true;
					break;
				}
			}
		}
	}while(nonUnique);
	return id;
}
	
	public double checkBalance() {
	return this.balance;
	
	//look up other transfer methods
	public boolean transfer(Account other, double amount) {
		if(this.balance >= amount) {
			this.balance -= amount;
			other.balance += amount;
			return true;
		}
		return false;
	}
	}