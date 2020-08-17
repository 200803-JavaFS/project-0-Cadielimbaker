package com.revature.services;

	import java.util.List;

	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;

	import com.revature.daos.UserDAO;
	import com.revature.daos.AccountDAO;
	import com.revature.daos.IUserDAO;
	import com.revature.daos.IAccountDAO;
	import com.revature.models.User;
	import com.revature.models.Account;

	public class AccountServices {

	private static IUserDAO udao = new UserDAO();
	private static IAccountDAO dao = new AccountDAO();
	private static final Logger log = LogManager.getLogger(UserServices.class);
	
	public List<Account> findAll() {
		log.info("Retrieving all bank accounts");
		List<Account> list = dao.findAll();

		return list;
	}
	
	public boolean updateAccountStatus(String accountStatus, int accountId) {
		log.info("Updating the account status:" + accountStatus);
		return dao.updateAccountStatus(accountStatus, accountId);
	}

	//locates a account based on account id
	public Account findByAccountId(int accountId) {
		log.info("Finding an account with account id " + accountId);
		return dao.findByAccountId(accountId);
	}

	//updates a given account
	public boolean updateAccount(Account acct) {
		log.info("Updating account: " + acct);
		if (dao.updateAccount(acct)) {
			return true;
		}
		return false;
	}

	//GET SOMEONE TO LOOK OVER METHOD wants me to chance my getId method to static
	public boolean insertAccount(Account acct) {

		if (acct.getId() != 0 ) {
			List<User> list = udao.findAllUser();
			boolean b = false;
			for (User u : list) {
				if (u.equals(acct.getId())) {
					b = true;
				}
			}
			if (b) {
				log.info("Creating a new Account: "+acct);
				if (dao.addAccount(acct)) {
					return true;
				}
			}
		} else {
			log.info("Creating a new Account: "+acct);
			if(dao.addAccount(acct)) {
				return true;
			}
		}
		return false;
	}

	
	
	public double deposit(double amount, int accountId) {
		
		Account a = dao.findByAccountId(accountId);
		
		if (amount < 0) {
			log.info("The amount must be greater than 0.00 for a deposit");
			
		}else {
			log.info("Making a deposit of" + amount + "from account id: " + accountId);
			double newBalance = a.getBalance() + amount;
			a.setBalance(newBalance);
			dao.updateBalance(newBalance, accountId);
			
	}
		System.out.println("This deposit was successful!");
		return a.getBalance();
	}
		
	public double withdraw(double amount, int accountId) {
		
		Account a = dao.findByAccountId(accountId);
		
		if( amount <= a.getBalance()) {
			log.info("Making a wihdrawal of" + amount + "from account id:" + accountId);
			double newBalance = a.getBalance() - amount;
			a.setBalance(newBalance);
			dao.updateBalance(newBalance, accountId);
	}else {
		log.info("Insufficient funds!");	
	}
	System.out.println("This withdrawl was successful!");
	return a.getBalance();
	}
	}


	
	