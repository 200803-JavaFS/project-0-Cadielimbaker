	package com.revature.daos;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.utils.ConnectionUtility;
import com.revature.daos.UserDAO;
import com.revature.daos.IUserDAO;

	public class AccountDAO implements IAccountDAO {
		private IUserDAO udao = new UserDAO();
		
		@Override
		//Finding all the accounts
		public List<Account> findAll() {
			
			try(Connection conn = ConnectionUtility.getConnection()){
				String sql = "SELECT * FROM Account;";
				
				Statement statement = conn.createStatement();
				List<Account> list = new ArrayList<>();
				ResultSet result = statement.executeQuery(sql);
				
				while(result.next()) {
					Account acct = new Account();
					acct.setAccountId(result.getInt("accountId"));	//This is pulling an AccountId string from the AccountId column 
																		//and set it as the AccountId field in my new Account object
					acct.setAccountType(result.getString("accountType"));
					acct.setId(result.getInt("Id_fk"));
					acct.setAccountStatus(result.getString("accountStatus"));
					acct.setBalance(result.getDouble("balance"));
					
					return list;
					}
				
				return list;
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
			return null;
		}

		@Override
		public Account findByAccountId(int accountId) {
			try(Connection conn = ConnectionUtility.getConnection()){
				
				String sql = "SELECT * FROM Account WHERE AccountId = ?;";
				
				PreparedStatement statement = conn.prepareStatement(sql);
				
				statement.setInt(1, accountId);
				
				ResultSet result = statement.executeQuery();
				
				if(result.next()) {
					Account acct = new Account();
					acct.setAccountId(result.getInt("accountId"));	
					acct.setAccountType(result.getString("accountType"));
					acct.setId(result.getInt("id_fk"));
					acct.setAccountStatus(result.getString("accountStatus"));
					acct.setBalance(result.getDouble("balance"));
					
					return acct;
					
				} else {
					//log a failed query
					return null;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public boolean addAccount(Account acct) {
			
			try(Connection conn = ConnectionUtility.getConnection()){
				
				String sql = "INSERT INTO Account (accountType, accountStatus, balance)"
						+ "VALUES (?, ?, ?);";
				
				PreparedStatement statement = conn.prepareStatement(sql);
				
				int index = 0;
				statement.setString(++index, acct.getAccountType());
				statement.setString(++index, acct.getAccountStatus());
				statement.setDouble(++index, acct.getBalance());
				
				statement.execute();
				return true; 
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return false;
		}

		//DO THIS ONE LIKE THE UPDATE USER IN THE USERDAO
		@Override
		public boolean updateAccount(Account acct) {
			try (Connection conn = ConnectionUtility.getConnection()) {
				String sql = "UPDATE Account SET accountType = ?, accountStatus = ?, balance = ?"
						+ " WHERE accountId = ?;";
				
				PreparedStatement statement = conn.prepareStatement(sql);

				int index = 0;
				statement.setString(++index, acct.getAccountType());
				statement.setString(++index, acct.getAccountStatus());
				statement.setDouble(++index, acct.getBalance());
				
				statement.execute();
				return true;
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return false;
		}
		
		@Override
		public boolean updateAccountStatus(String accountStatus, int accountId) {
			try (Connection conn = ConnectionUtility.getConnection()) {
				String sql = "UPDATE Account SET accountStatus = ?"
						+ " WHERE accountId = ?;";
				
				PreparedStatement statement = conn.prepareStatement(sql);

				int index = 0;
	
				statement.setString(++index, accountStatus);
				statement.setInt(++index, accountId);
				
				statement.execute();
				return true;
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return false;
		}
		
	

		@Override
		public boolean updateBalance(double balance, int accountId){
			try (Connection conn = ConnectionUtility.getConnection()) {
				String sql = "UPDATE Account SET balance = ?"
						+ " WHERE accountId = ?;";
				
				PreparedStatement statement = conn.prepareStatement(sql);

				int index = 0;

				statement.setDouble(++index, balance);
				statement.setInt(++index, accountId);
				
				statement.execute();
				return true;
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return false;
		}
		}


		