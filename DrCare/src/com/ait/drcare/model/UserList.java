package com.ait.drcare.model;

import java.util.ArrayList;

public class UserList {
	private ArrayList<User> users;

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	public boolean userExists(User user) {
		boolean exists = false;
		for (User u : users) {
			if(u.getTheID() == (user.getTheID())) {
				exists = true;
			}
		}
		return exists;
	}
}
