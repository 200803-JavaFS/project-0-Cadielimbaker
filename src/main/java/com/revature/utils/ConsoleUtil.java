package com.revature.utils;

import java.util.Scanner;
import com.revature.services.AccountServices;


public class ConsoleUtil {
	private static final Scanner sc = new Scanner(System.in);
	private AccountServices as = new AccountServices();
	
	//finish this beginApp method
	public void beginApp() {
		System.out.println("Welcome to the Bank of Revature" 
				+ "Please, select from the following options: "
				)
	}
}

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
