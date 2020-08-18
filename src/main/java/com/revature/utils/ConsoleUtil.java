package com.revature.utils;

import java.util.List;
import java.util.Scanner;

import com.revature.models.User;
import com.revature.models.Account;
import com.revature.services.AccountServices;
import com.revature.services.UserServices;
import com.revature.daos.AccountDAO;
import com.revature.daos.UserDAO;


public class ConsoleUtil {
	private static final Scanner scan = new Scanner(System.in);
	private AccountServices as = new AccountServices();
	private UserServices us = new UserServices();
	private AccountDAO ad = new AccountDAO(); 
	
	
	//finish this login()
	public void login() {
		
			User u = us.login("", "");
			System.out.println("Here is your user information" + (u));
		
		try (Scanner scanner = new Scanner(System.in)) {
	        System.out.print(" Enter user name: ");
	        String userName = scanner.nextLine();

	        System.out.print(" Enter password: ");
	        String password = scanner.nextLine();

	        if ("cadielimbaker".equals(userName) && "password".equals(password)) {
	            System.out.println(" User successfully logged-in! ");
	        } else {
	            System.out.println(" In valid userName or password! ");
	        }
	        beginApp();
	    }
	}
		
		public void beginApp() {
			
		System.out.println("Welcome to the Bank of Revature! Select what you need:"
				+ "Please [login], enter username and then password"
				+ "Please [add user]"
				+ "Please [add account]"
				+ "Please [update account]"
				+ "Please [approve account]"
				+ "Please [deny account]"
				+ "Please [close account]"
				+ "Please [update user]"
				+ "Please [deposit] money"
				+ "Please [withdrawl] money"
				+ "Please [transfer] money"
				+ "Please show [all users]"
				+ "Please show [all accounts]"
				+ "Please show [one user]"
				+ "Please show [one account], you will be able to view the balance here");
		
				String answer = scan.nextLine();
				 answer = scan.nextLine(); 
				answerSwitch(answer);
	}
	private void answerSwitch(String answer) {
		answer = answer.toLowerCase();
		
		switch(answer){
		case "exit":
			System.out.println("Thank you, see you next time!");
			break;
		case "create user":
			addUser();
			break;
		case "add account":
			addAccount();
			break;
		case "approve account":
			updateAccountStatus(); 
			break;
		case "deny account":
			updateAccountStatus();
			break;
		case "close account":
			closeAccount();
			break;
		case "deposit":
			
			System.out.println("What is the account id for the account you are depositing into?");
			int accountId = scan.nextInt();
			scan.nextLine();
			System.out.println("What is the amount you would like to deposit (two decimals)?");
			double amount = scan.nextDouble();
			
			AccountServices.deposit(amount, accountId);
			beginApp();
			break;
		case "withdrawal":
			System.out.println("What is your user type, give the number: (0)Customer, (1)Employee, (2)Administrator.");
			int userType = scan.nextInt();
			scan.nextLine();
			
			if ( userType != 1) {
				System.out.println("What is the account id for the account you are withdrawaling from?");
				int i = scan.nextInt();
				scan.nextLine();
				System.out.println("What is the amount you would like to withdrawal (two decimals)?");
				double money = scan.nextDouble();
				
				AccountServices.withdraw(money, i);
				beginApp();
		}else {
			System.out.println("You do not have access to withdrawal");
			beginApp(); 
		}
			
			break;
		case "transfer":
			transfer();
			break;
		case "all users":
			findAllUser();
			break;
		case "all accounts":
			findAll();
			break;
		case "one user":
			findById();
			break;
		case "one account":
			findByAccountId();
			break;
		
			default:
				System.out.println("You have entered incorrect information. Please try again.");
				beginApp();
				break;
		}
				
	}
	

	private void closeAccount() {
		System.out.println("What is your user type, give the number: (0)Customer, (1)Employee, (2)Administrator.");
		int userType = scan.nextInt();
		scan.nextLine();
		
		if ( userType == 2) {
			System.out.println("What is the account id of the account you are looking for?");
			int accountId = scan.nextInt();
			scan.nextLine();
			Account acct = as.findByAccountId(accountId);
			System.out.println("The account is: "+acct);
			scan.nextLine();
			System.out.println("You may update the account status to [Closed], type Closed.");
			String accountStatus = scan.nextLine();
			as.updateAccountStatus(accountStatus, accountId);
			ad.updateBalance(0.00, accountId);

			beginApp();
				
	}else {
		System.out.println("You do not have access to close this account");
		beginApp(); 
	}
	}
		

	private void findByAccountId() {
		
		System.out.println("What is the account id of the account you are looking for?");
		int accountId = scan.nextInt();
		scan.nextLine();
		Account acct = as.findByAccountId(accountId);
		System.out.println("The account is: "+acct);
		beginApp();
	}
		

	private void findById() {
		System.out.println("What is the id of the user you are looking for?");
		int Id = scan.nextInt();
		scan.nextLine();
		User u = us.findById(Id);
		System.out.println("The user is: "+u);
		beginApp();
	}
		

	private void findAll() {
		System.out.println("What is your user type, give the number: (0)Customer, (1)Employee, (2)Administrator.");
		int userType = scan.nextInt();
		scan.nextLine();
		
		if ( userType != 0) {
			List<Account> list = as.findAll();
			
			System.out.println("Here are all the accounts in the database:");
			for(Account acct:list) {
				System.out.println(acct);
			}
			beginApp();
		
	}else {
		System.out.println("You do not have access to update the account balance");
		beginApp(); 
	}
	}
	

	private void findAllUser() {
		System.out.println("What is your user type, give the number: (0)Customer, (1)Employee, (2)Administrator.");
		int userType = scan.nextInt();
		scan.nextLine();
		
		if ( userType != 0) {
			List<User> list = us.findAllUser();
			System.out.println("Here are all the users in the database:");
			
			for(User u:list) {
				System.out.println(u);
			}
			beginApp();
	}else {
		System.out.println("You do not have access to update the account balance");
		beginApp(); 
	}
	}
	

	public void transfer() {
		System.out.println("What is your user type, give the number: (0)Customer, (1)Employee, (2)Administrator.");
		int userType = scan.nextInt();
		scan.nextLine();
		
		if ( userType != 1) {
			System.out.println("What is the account id for the account you are withdrawaling from?");
			int accountId1 = scan.nextInt();
			scan.nextLine();
			Account acct1 = as.findByAccountId(accountId1);
			System.out.println("What is the id of the account you are transferring into?");
			int accountId2 = scan.nextInt();
			scan.nextLine();
			Account acct2 = as.findByAccountId(accountId2);
			System.out.println("What is the amount you are planning to transferring?");
			double transferAmount = scan.nextDouble();
			scan.nextLine();
			AccountServices.withdraw(transferAmount, accountId1);
			AccountServices.deposit(transferAmount, accountId2);
			
			double newAcc1Balance = acct1.getBalance() + transferAmount;
			acct1.setBalance(newAcc1Balance);
			ad.updateBalance(newAcc1Balance, accountId1);
			
			double newAcc2Balance = acct2.getBalance() + transferAmount;
			acct1.setBalance(newAcc2Balance);
			ad.updateBalance(newAcc2Balance, accountId2);
			
			System.out.println("The new balance for the first account with id is: "+newAcc1Balance);
			System.out.println("The new balance for the second account with id is: "+newAcc2Balance);
			beginApp();
	}else {
		System.out.println("You do not have access to transfer");
		beginApp(); 
	}
	}

	//don't think I need this method anymore
	private void updateBalance() {
		System.out.println("What is the id of the account you would like to look at?");
		int i = scan.nextInt();
		scan.nextLine();
		Account a = as.findByAccountId(i);
		System.out.println("Here is the corresponding account: "+a);
		System.out.println("What is your user type, give the number: (0)Customer, (1)Employee, (2)Administrator.");
		int userType = scan.nextInt();
		scan.nextLine();
		
		if ( userType != 1) {
			System.out.println("You may update the account status to [Approved] or [Denied], which do you choose?");
			String accountStatus = scan.nextLine();
			as.updateAccountStatus(accountStatus, i);
	}else {
		System.out.println("You do not have access to update the account balance");
		beginApp(); 
	}
	}

	
	private void updateAccountStatus() {
		System.out.println("What is the id of the account you would like to look at?");
		int i = scan.nextInt();
		scan.nextLine();
		Account a = as.findByAccountId(i);
		System.out.println("Here is the corresponding account: "+a);
		System.out.println("What is your user type, give the number: (0)Customer, (1)Employee, (2)Administrator.");
		int userType = scan.nextInt();
		scan.nextLine();
		
		if ( userType != 0) {
			System.out.println("You may update the account status to [Approved] or [Denied], which do you choose?");
			String accountStatus = scan.nextLine();
			as.updateAccountStatus(accountStatus, i);
	}else {
		System.out.println("You do not have access to update account status");
		beginApp(); 
	}
	}

	public void addAccount() {
		System.out.println("What type of account are you adding (Checking) or (Savings)?");
		String accountType = scan.nextLine();
		System.out.println("What is your user id?");
		int Id_fk = scan.nextInt();
		scan.nextLine();
		System.out.println("Your account status will remain pending until appication is approved (MUST ENTER Pending)");
		String accountStatus = scan.nextLine();
		System.out.println("Enter a balance amount (format ie. 0.00)");
		double balance = scan.nextDouble();
		
		Account acct = new Account(accountType, Id_fk, accountStatus, balance);
		
		if(as.insertAccount(acct)) {
			System.out.println("Your account was added to the database");
			beginApp();
		} else {
			System.out.println("Something went wrong please try again");
			beginApp(); 
		}
	}

	private void addUser() {
		System.out.println("What is the first name of the user you would like to add?");
		String firstName = scan.nextLine();
		System.out.println("What is the last name of the user you would like to add?");
		String lastName = scan.nextLine();
		System.out.println("What is the user name of the user you would like to add?");
		String userName= scan.nextLine();
		System.out.println("What is the phone number of the user you would like to add?");
		int phoneNumber= scan.nextInt();
		scan.nextLine();
		System.out.println("What is the password of the user you would like to add?");
		String password = scan.nextLine();
		System.out.println("Are you a Customer(0), Employee(1), or Administrator(2), please enter the number?");
		int I = scan.nextInt();
		scan.nextLine();
		
		User u = new User(firstName, lastName, userName, phoneNumber, password, I);
		
		if(us.insertUser(u)) {
			System.out.println("Your user was added to the database");
			beginApp();
		} else {
			System.out.println("Something went wrong please try again");
			beginApp(); 
		}
	
	}
}
	
		
		
		