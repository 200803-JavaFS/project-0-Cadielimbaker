	package com.revature.driver;
	import com.revature.daos.AccountDAO;
	import java.util.List;
	import com.revature.models.Account;
import com.revature.models.USERTYPE;
	
	public class Driver {

	private static AccountDAO dao = new AccountDAO();
	
	public static void main(String[] args) {
		List<Account> list = dao.findAll();
		
		//test if you can print a list of all the accounts in the database
		for(Account acct: list) {
			System.out.println(acct);
		}
		
		Account acct = new Account("Checking", 100100100, "Pending", 100.00);
	}
	
	//might need to move this method
	public void getUserType() {
    System.out.println("The string value of CUSTOMER is " + USERTYPE.CUSTOMER.toString());
    System.out.println("The string value of EMPLOYEE is " + USERTYPE.EMPLOYEE.toString());
    System.out.println("The string value of Administrator is " + USERTYPE.ADMINISTRATOR.toString());
	}
	}