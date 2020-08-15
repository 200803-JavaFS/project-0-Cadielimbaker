	package com.revature.daos;

	import java.util.List;

	import com.revature.models.Account;
import com.revature.models.User;

	public interface IAccountDAO {
	
		public List<Account> findAll();
		public Account findByAccountId(String AccountId);
		public boolean addAccount(Account acct ); //returns a boolean so that you know if the method was successful
		public boolean updateAccountStatus(String accountStatus);
		public boolean addAccountwithUser(Account acct);
}
