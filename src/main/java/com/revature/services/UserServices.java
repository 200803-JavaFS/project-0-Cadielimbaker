package com.revature.services;

import java.util.Random;

import com.revature.models.User;

public class UserServices {

}

//method for new id for a new user
public String getNewUserID() {

	String id; //initialize the id string
	Random rng = new Random(); //Random number generator
	int len = 6;
	boolean nonUnique;
	
	//do while loop that will continue looping until I get a unique user id
	do {
		
		id = ""; //generate an id integer/number
		for(int i = 0; i<len ; i++) {
			id +=((Integer)rng.nextInt(10)).toString(); //wrapper class to add an integer from 0 to 9 in string form
		}
		nonUnique = false; //check for uniqueness
		for(User u: this.users) {
			if(id.compareTo(u.getID())==0) {
				nonUnique = true;
				break;
			}
		}
	}while(nonUnique);
	return id;
}