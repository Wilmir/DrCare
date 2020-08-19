package com.ait.drcare.managedbeans.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.ait.drcare.Doctor;
import com.ait.drcare.Patient;
import com.ait.drcare.Pharmacist;
import com.ait.drcare.User;
import com.ait.drcare.UserList;
import com.ait.drcare.managedbeans.UserBean;

@ManagedBean
@RequestScoped
public class RegistrationController {

	@ManagedProperty(value = "#{studentBean}")
	private UserBean userBean;
	
	// Align with Fiona's implementation on UserList. 
	private UserList existingUsers = new UserList();
	
	private User user;
	
	@PostConstruct
	public void init() {
		// instantiate a user depending on the roles bean type
		switch(userBean.getRole()) {
			case "1":
				user = new Doctor();
				break;
			case "2":
				user = new Pharmacist();
				break;
			default:
				user = new Patient();
				break;
		}
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	public String addUser() {
		// 1. Check if user is not existing
		// Align with Fiona's userList implementation 
		/*
		for(User existingUser : existingUsers.getUsers()) {
			if(existingUser.getTheEmail().equalsIgnoreCase(user.getTheEmail())) {
				return "The email you entered already belongs to an existing user";
			}	
		}
		*/
		
		// 2. Check if the passwords entered match
		if(userBean.getPassword().equals(userBean.getPasswordConfirmation())) {
			user.setThePassword(userBean.getPassword());
		}else {
			return "The passwords entered do not match";
		}
		
		
		// 3. Add the remaining attributes from the userBean to the User object
		user.setTheName(userBean.getName());
		user.setTheEmail(userBean.getEmail());
		
		
		// 4 Verify the user through the admin utility verification method
		// Align with Fiona's implem of userList
		/*
		if(true) {
			// 5 Add the user to the user's list
			return "Your account has been successfully created.";
		}else{
			return "We are unable to verify your account";
		}
		*/
		
		return "Registration status";
	
	}
	
}
