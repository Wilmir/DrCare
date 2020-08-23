package com.ait.drcare.managedbeans.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.ait.drcare.managedbeans.Helper;
import com.ait.drcare.managedbeans.UserBean;
import com.ait.drcare.managedbeans.UserListBean;
import com.ait.drcare.model.User;

@ManagedBean
@SessionScoped
public class LoginController {

	private UserBean userBean = Helper.getBean("userBean", UserBean.class);
	private UserListBean existingUsers = Helper.getBean("userListBean", UserListBean.class);
	private String message ="";
	private int numOfAttempts=1;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void validateUserLogin() {
		String givenUser = userBean.getEmail();
		String givenPassword = userBean.getPassword();
		User registeredUser = new User();
		Boolean userFound = false;
		
		for(User existingUser : existingUsers.getUsers()) {
			if(existingUser.getTheEmail().equalsIgnoreCase(givenUser)){
				registeredUser = existingUser;
				userFound = true;
			}
		
		}
			
		if(userFound.equals(false)) {
			message = "The given user is not registed in the System. Please Register";
			System.out.println(message);
			return;
		}
		
		if(registeredUser.getAccountLock().equals(true)) {
			message = "Account Locked";
			System.out.println(message);
			return;
		}
		
		if(givenPassword.equals(registeredUser.getThePassword())){
			message = "Login Successfull";
			System.out.println(message);
			return;
		}
		else {
				numOfAttempts++;
		        if (numOfAttempts > 5)
		        {
		         System.out.println("loginlocked");
		         registeredUser.setAccountLock(true);
		        }
		        else
		        {
		         System.out.println("loginfailure");
		        }
		}
		}
	}
