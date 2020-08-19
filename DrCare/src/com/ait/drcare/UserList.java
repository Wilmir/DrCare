package com.ait.drcare;

import java.util.ArrayList;

public class UserList {
	//string placeholder until user class is created
	private ArrayList<String> users;

	public ArrayList<String> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<String> users) {
		this.users = users;
	}
	
	public void addUser(String user) {
		this.users.add(user);
	}
	
	public boolean userExists(String user) {
		boolean exists = false;
		for (String u : users) {
			if(u.equals(user)) {
				exists = true;
			}
		}
		return exists;
	}
}
