package com.ait.drcare.managedbeans.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.ait.drcare.managedbeans.UserBean;

@ManagedBean
@RequestScoped
public class RegistrationController {

//	@ManagedProperty(value = "#{studentBean}")
	private UserBean userBean;
	
	
	// 1. Add a User reference as a member variable here
	
	
	@PostConstruct
	public void init() {
		// 1. Instantiate the user
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
	public String addUser() {
		// 1. Add the attributes from the userBean to the User object
		
		
		// 2. Check if user is not existing
		// 2.a Verify the user
		// 2.b Add the user to the user list
		
		
		// 3. If user is existing, return a message "User already exists"
		
		
		return "Notification for registration status.";
		
	}
	
}
