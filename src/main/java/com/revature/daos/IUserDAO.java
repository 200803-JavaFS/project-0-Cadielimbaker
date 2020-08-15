package com.revature.daos;


import java.util.List;

import com.revature.models.User;

public interface IUserDAO {
	
	public List<User> findAllUser();
	
	public User findById(int Id);
	
	public boolean addUser(User u);
	
	public boolean updateUser(User u); 
	
	//typically Banks do not delete information, but I included it here just in case
	public boolean deleteUser(int Id);

}