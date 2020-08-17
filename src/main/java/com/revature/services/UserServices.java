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

	public class UserServices {

	private static IUserDAO udao = new UserDAO();
	private static IAccountDAO dao = new AccountDAO();
	private static final Logger log = LogManager.getLogger(UserServices.class);
	private Account acct;

	public List<User> findAllUser() {
		log.info("Retrieving all bank users");
		List<User> list = udao.findAllUser();

		return list;
	}
	
	//login a user
	public User login(String userName, String password) {
		log.info("Login in with userName and password" + userName + password);
		return udao.login(userName, password);
	}
		
	//locates a user based on id
	public User findById(int Id) {
		log.info("Finding a user with id " + Id);
		return udao.findById(Id);
	}

	//updates a given user
	public boolean updateUser(User u) {
		log.info("Updating user: " + u);
		if (udao.updateUser(u)) {
			return true;
		}
		return false;
	}

	//adds a user but checks to see if the user already exists based on user name, if so it will return a list of all accounts
	public boolean insertUser(User u) {

		if (u.getUserName() != null) {
			List<Account> list = dao.findAll();
			boolean b = false;
			for (Account acct : list) {
				if (acct.equals(u.getId())) {
					b = true;
				}
			}
			if (b) {
				log.info("Inserting user: " + u);
				if (udao.addUser(u)) {
					return true;
				}
			}
		} else {
			log.info("Inserting User: " + u);
			if (udao.addUser(u)) {
				return true;
			}
		}
		return false;
		
	}
}
