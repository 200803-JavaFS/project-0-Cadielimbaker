	package com.revature.daos;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import com.revature.models.Account;
	import com.revature.utils.ConnectionUtility;

	public class AccountDAO implements IAccountDAO {

		@Override
		//Finding all the accounts
		public List<Account> findAll() {
			
			try(Connection conn = ConnectionUtility.getConnection()){
				String sql = "SELECT * FROM Account;";
				
				Statement statement = conn.createStatement();
				List<Account> list = new ArrayList();
				ResultSet result = statement.executeQuery(sql);
				
				while(result.next()) {
					Account acct = new Account();
					acct.setAccountId(result.getString("accountId"));	//This is pulling an AccountId string from the AccountId column 
																		//and set it as the AccountId field in my new Account object
					acct.setAccountType(result.getString("accountType"));
					acct.setId(result.getInt("Id_fk"));
					//acct.setAccountStatus(accountStatus);
					acct.setBalance(result.getDouble("balance"));
					
				}
				
				return list;
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			return null;
		}

		@Override
		public Account findByAccountId(String AccountId) {
			try(Connection conn = ConnectionUtility.getConnection()){
				
				String sql = "SELECT * FROM Account WHERE AccountId = ?;";
				
				PreparedStatement statement = conn.prepareStatement(sql);
				
				statement.setString(1, AccountId);
				
				ResultSet result = statement.executeQuery();
				
				if(result.next()) {
					Account acct = new Account();
					acct.setAccountId(result.getString("accountId"));	//This is pulling an AccountId string from the AccountId column 
																		//and set it as the AccountId field in my new Account object
					acct.setAccountType(result.getString("accountType"));
					acct.setId(result.getInt("Id_fk"));
					//acct.setAccountStatus(accountStatus);
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
				
				String sql = "INSERT INTO Account (accountId, accountType, Id_fk, accountStatus, balance)"
						+ "VALUES (?, ?, ?, ?, ?);";
				//not all need question marks, but they don't hurt they can only help
				
				PreparedStatement statement = conn.prepareStatement(sql);
				
				int index = 0;
				statement.setString(++index, acct.getAccountId());
				statement.setString(++index, acct.getAccountType());
				statement.setInt(++index, acct.getId());
				//statement.setString(++index, acct.getAccountStatus());
				statement.setDouble(++index, acct.getBalance());
				
				statement.execute();
				return true; 
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return false;
		}

	}


		