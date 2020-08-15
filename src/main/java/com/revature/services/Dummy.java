package com.revature.services;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;

import com.revature.models.Transaction;
import com.revature.models.Account;
import com.revature.models.Bank;
import com.revature.models.User;

public class Dummy {
}


//Method for viewing all the accounts (SELECT * FROM Account);
//Method for add an account INSERT INTO Account(parameters) VALUES(info for parameters);
//Method to change an account

//=========================================
//method to add an account for the user
	public void addAccount(Account anAccount) {
		this.accounts.add(anAccount); //encapsulation because the accounts property is private
		}
	//===========================================================================	
		//method to add an account status for the user's account
		//NEED TO FIGURE OUT HOW TO ADD PARAMETER'S (Opened, Closed, Denied, Pending)
		public void addAccountStatus(Account anAccountStatus) {
			this.accounts.add(anAccountStatus);
				}

		
//==================================================================================		
		//method for new id for a new user
		public String getNewUserID() {

			String id; //initialize the id string
			Random rng = new Random(); //Random number generator
			int len = 6;
			boolean nonUnique;
			
			//do while loop that will continue looping until I get a unique user id
			do {
				
				id = ""; //generate an id integer/number
				for(int i = 0; i<len ; i++) {
					id +=((Integer)rng.nextInt(10)).toString(); //wrapper class to add an integer from 0 to 9 in string form
				}
				nonUnique = false; //check for uniqueness
				for(User u: this.users) {
					if(id.compareTo(u.getID())==0) {
						nonUnique = true;
						break;
					}
				}
			}while(nonUnique);
			return id;
		}
		
		
//==========================================================================		
		
		public User userLogin(String userID, String pin) {
			for(User u: this.users) {
				if(u.getID().compareTo(userID)==0 && u.checkPin(pin)) {
					return u;
				}
			}
			//if no user was found or the pin was incorrect, return null
			return null;
		}

		//method for checking the pin
		public boolean checkPin(String aPin) {
			//non-invertible function 
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				System.err.println("error, NoSuchAlgorithm");
				e.printStackTrace();
				System.exit(1);
			}
			return false;
		}
		
		
		//==========================================================================
				
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
								if(id.compareTo(a.getID())==0) {
									nonUnique=true;
									break;
								}
							}
						}
					}while(nonUnique);
					return id;
				}
		
		//========================================================
				
				//method to create a new user
				public User addUser(String firstName, String lastName, String pin, String accountStatus, String userType, Bank myBank) {
					User newUser = new User(firstName, lastName, pin, userType, this); //new user object
					this.users.add(newUser);
					
					//create a savings account
					Account newAccount = new Account("Savings", newUser, accountStatus, this) {
					newUser.addAccount(newAccount);
					this.addAccount(newAccount);
					
					return newUser;
				}
		
		//=================================================================
				
				public boolean checkPin(String aPin) {
			//non-invertible function
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
			} catch (NoSuchAlgorithmException e) {
				System.err.println("error, NoSuchAlgorithm");
				e.printStackTrace();
				System.exit(1);
			}
			return false;
		}
				
		//=============================================================
				
				//Hash our pin (MD5 algorithm) and store it
				try {
					MessageDigest md = MessageDigest.getInstance("MD5");
					this.pinHash = md.digest(pin.getBytes());
				} catch (NoSuchAlgorithmException e) {
					System.err.println("error, NoSuchAlgorithm");
					e.printStackTrace();
					System.exit(1);
				}
				
				//how to get a new id for the new user
				this.id = myBank.getNewUserID();
				
				
				//=========================================================
						
						//get a new account id
						this.id = myBank.getNewAccountID();
		//===============================================
						//this section was my old scanner
						
						public class AtmConsole {

							public static void main(String[] args) {
								
								//initialize the Scanner
								Scanner sc = new Scanner(System.in);
								
								//create myBank
								Bank myBank = new Bank("Bank of Revature");
								
								//add a user to the bank with a savings account
								//String accountStatus, String userType, Bank myBank
								User aUser = myBank.addUser("Cadie", "Limbaker", "123456", "Savings", "Customer", myBank);
								
								//add a checking account for this user,
								Account newAccount = new Account("Checking", aUser, "Pending Status", myBank);
								aUser.addAccount(newAccount); //adding the checking account to the Account's list
								myBank.addAccount(newAccount); //adding the checking account to the Bank's list
								
								//infinite menu loop as long as true
								User atmUser;
								while(true) {
									//atm User stays in the login prompt menu until successful login
									atmUser = atm.mainMenuPrompt(myBank, sc);
									
									//atm User remains in the main menu until they quit
									atm.printUsermenu(atmUser, sc);
								}
								
							}
							
							public static User mainMenuPrompt(Bank myBank, Scanner sc) {
								//variables for prompt
								String userID;
								String pin;
								User validateUser;
								
								//prompt the user to first enter user pin and user id until correct before moving on
								do {
									System.out.println("Welcome to"+ myBank.getName());
									System.out.println("Please enter your user ID: ");
									userID = sc.nextLine();
									System.out.println("Please enter your pin: ");
									pin = sc.nextLine();
									
									//attempt to receive the user object of that user id and pin combination
									validateUser = userLogin(userID, pin);
									if(validateUser == null) {
										System.out.println("Submitted an incorrect user id/pin combination. "+ "Please try again:");
									}
								}while()
							}
							
						}
