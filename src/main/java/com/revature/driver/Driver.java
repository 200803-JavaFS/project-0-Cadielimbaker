	package com.revature.driver;
	import com.revature.daos.AccountDAO;
	import com.revature.daos.UserDAO;
	import java.util.List;
	import com.revature.models.Account;
import com.revature.utils.ConsoleUtil;
	
	public class Driver {

	private static AccountDAO dao = new AccountDAO();
	
	public static void main(String[] args) {
		//List<Account> list = dao.findAll();
		
		//test if you can print a list of all the accounts in the database
		//for(Account acct: list) {
			//System.out.println(acct);
		//}
		
		//Account acct = new Account("Checking", 100100100, "Pending", 100.00);
		//System.out.println(dao.addAccount(acct));
	//}
		ConsoleUtil cons = new ConsoleUtil();
		cons.login2();
	}
	}