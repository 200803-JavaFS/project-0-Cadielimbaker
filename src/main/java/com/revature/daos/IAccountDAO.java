	package com.revature.daos;

	import java.util.List;

	import com.revature.models.Account;
import com.revature.models.User;

	public interface IAccountDAO {
	
		public List<Account> findAll();
		public Account findByAccountId(int accountId);
		public boolean addAccount(Account acct ); //returns a boolean so that you know if the method was successful
		public boolean updateAccount(Account acct);
		public boolean updateAccountStatus(String accountStatus, int accountId);
		public boolean updateBalance(double balance, int accountId);
}
