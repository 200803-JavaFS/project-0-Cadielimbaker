package com.revature.models;
import com.revature.models.User;
public class Administrator {

}



public class Administator extends User{
	public Administrator(String user, String pass) {
		super(user, pass, USER.ADMINISTRATOR);
	}
}