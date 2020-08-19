package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.User;
import com.revature.models.Account;
import com.revature.utils.ConnectionUtility;

public class UserDAO implements IUserDAO {

	@Override
	public List<User> findAllUser() {
		
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM Users;";
			
			Statement statement = conn.createStatement();
			
			List<User> list = new ArrayList<>(); 
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				User u = new User();
				u.setFirstName(result.getString("firstName"));
				u.setLastName(result.getString("lastName"));
				u.setUserName(result.getString("userName"));
				u.setPhoneNumber(result.getInt("phoneNumber"));
				u.setPassword(result.getString("password"));
				u.setUserType(result.getInt("userType"));
				u.setId(result.getInt("Id"));
				list.add(u); 
			}
			
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public User findById(int Id) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM Users WHERE Id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, Id);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				User u = new User();
				u.setFirstName(result.getString("firstName"));
				u.setLastName(result.getString("lastName"));
				u.setUserName(result.getString("userName"));
				u.setPhoneNumber(result.getInt("phoneNumber"));
				u.setPassword(result.getString("password"));
				u.setUserType(result.getInt("userType"));
				u.setId(result.getInt("Id"));
				return(u); 
				
			} else {
				//good place to log a failed query.
				System.out.println("No Id found: incorrect Id entered or need to create a new user profile");
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User u) {
		
		try(Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "INSERT INTO Users (firstName, lastName, userName, phoneNumber, password, userType)"
					+ "VALUES (?, ?, ?, ?, ?, ?);"; //not all these ?s are required
		
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setString(++index, u.getUserName());
			statement.setInt(++index, u.getPhoneNumber());
			statement.setString(++index, u.getPassword());
			statement.setInt(++index, u.getUserType());
			
			statement.execute();
			return true; 
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean updateUser(User u) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "UPDATE Users SET firstName = ?, lastName = ?, userName = ?, "
					+ "phoneNumber = ?, password = ?, userType = ? WHERE Id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setString(++index, u.getUserName());
			statement.setInt(++index, u.getPhoneNumber());
			statement.setString(++index, u.getPassword());
			statement.setInt(++index, u.getUserType());
			
			statement.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	//Bank's normally do not delete information, but I have added this method just in case
	@Override
	public boolean deleteUser(int Id) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "DELETE FROM Users WHERE Id =" + Id + ";";

			Statement statement = conn.createStatement();

			statement.execute(sql);
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public User login(String userName) {
		try(Connection conn = ConnectionUtility.getConnection()){
			String sql = "SELECT * FROM Users WHERE userName = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, userName);
			
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				User u = new User();
				u.setFirstName(result.getString("firstName"));
				u.setLastName(result.getString("lastName"));
				u.setUserName(result.getString("userName"));
				u.setPhoneNumber(result.getInt("phoneNumber"));
				u.setPassword(result.getString("password"));
				u.setUserType(result.getInt("userType"));
				u.setId(result.getInt("Id"));
				return(u); 
				
			} else {
				//good place to log a failed query.
				System.out.println("No login combination found: incorrect userName/password entered or need to create a new user profile");
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

	