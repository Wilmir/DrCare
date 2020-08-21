package com.ait.drcare.managedbeans.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.ait.drcare.Doctor;
import com.ait.drcare.Patient;
import com.ait.drcare.Pharmacist;
import com.ait.drcare.User;
import com.ait.drcare.managedbeans.Helper;
import com.ait.drcare.managedbeans.UserBean;
import com.ait.drcare.managedbeans.UserListBean;

@ManagedBean
@RequestScoped
public class RegistrationController {
	
	private UserBean userBean = Helper.getBean("userBean", UserBean.class);
	
	private UserListBean existingUsers = Helper.getBean("userListBean", UserListBean.class);

	
	private User user;
	
	private String message ="";
	
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
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String addUser() {
		// 1. Check if user is not existing		
		for(User existingUser : existingUsers.getUsers()) {
			if(existingUser.getTheEmail().equalsIgnoreCase(user.getTheEmail())) {
				message = "The email you entered already belongs to an existing user";
				System.out.println(message);
				return null;
			}	
		}

		// 2. Check if the passwords entered match
		if(userBean.getPassword().equals(userBean.getPasswordConfirmation())) {
			user.setThePassword(userBean.getPassword());
		}else {
			message = "The passwords entered do not match";
			System.out.println(message);
			return null;
		}
		
		// 3. Add the remaining attributes from the userBean to the User object
		user.setTheName(userBean.getName());
		user.setTheEmail(userBean.getEmail());
		
		existingUsers.addUser(user);
				
		message = "Registration successul";
		
		
		for(User existingUser : existingUsers.getUsers()) {
			System.out.println(existingUser.getTheName() + " is now registered");
		}
		
		
		System.out.println(message);
		
		
		
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
		
		return null;
	}
}
