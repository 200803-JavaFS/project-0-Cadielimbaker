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
			String sql = "SELECT * FROM User;";
			
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
				u.setUserType(result.getString("userType"));
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
			String sql = "SELECT * FROM homes WHERE home_base = ?;";
			
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
				u.setUserType(result.getString("userType"));
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
			
			String sql = "INSERT INTO User (firstName, lastName, userName, phoneNumber, password, userType)"
					+ "VALUES (?, ?, ?, ?, ?, ?);"; //not all these ?s are required
		
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setString(++index, u.getUserName());
			statement.setInt(++index, u.getPhoneNumber());
			statement.setString(++index, u.getPassword());
			statement.setUSERTYPE(++index, u.getUserType());
			
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
			String sql = "UPDATE User SET Id = ?, firstName = ?, lastName = ?, userName = ?, "
					+ "phoneNumber = ?, password = ?, userType = ? WHERE Id = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setString(++index, u.getUserName());
			statement.setInt(++index, u.getPhoneNumber());
			statement.setString(++index, u.getPassword());
			statement.setUSERTYPE(++index, u.getUserType());
			
			statement.execute();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteUser(int Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUserWithAccount(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	//==============================================================================================

	@Override
	public boolean deleteAvenger(int supId) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			String sql = "DELETE FROM avengers WHERE superhero_id =" + supId + ";";

			Statement statement = conn.createStatement();

			statement.execute(sql);
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addAvengerWithHome(Avenger a) {
		try (Connection conn = ConnectionUtility.getConnection()){
			
			String sql = "BEGIN; "
					+ "INSERT INTO homes (home_base, hb_st_addr, hb_city, hb_state, hb_zip)"
					+ "VALUES (?, ?, ?, ?, ?);"
					+ "INSERT INTO avengers (superhero_name, superhero_power, first_name, last_name, power_level, home_base_fk)"
					+ "VALUES (?, ?, ?, ?, ?, ?);"
					+ "COMMIT;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			Home h = a.getHomeBase();
			
			int index = 0;
			statement.setString(++index, h.getHomeBase());
			statement.setString(++index, h.getStreetAddr());
			statement.setString(++index, h.getCity());
			statement.setString(++index, h.getState());
			statement.setString(++index, h.getZip());
			statement.setString(++index, a.getSupName());
			statement.setString(++index, a.getSupPower());
			statement.setString(++index, a.getFirstName());
			statement.setString(++index, a.getLastName());
			statement.setInt(++index, a.getPowerLevel());
			statement.setString(++index, h.getHomeBase());
			
			statement.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}