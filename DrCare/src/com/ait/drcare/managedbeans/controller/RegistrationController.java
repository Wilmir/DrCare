package com.ait.drcare.managedbeans.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
	
	private UserListBean registry = Helper.getBean("userListBean", UserListBean.class);

	private User user;
		
	@PostConstruct
	public void init() {
		// instantiate a user depending on the roles bean type
		switch(userBean.getRole()) {
			case "GP":
				user = new Doctor();
				break;
			case "Pharmacist":
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
		// 1. Check if the passwords entered match
		if(!passwordsMatch()){
			error("The passwords entered do not match");
			return null;
		}
		
		// 2. Check if user is not existing		
		if(isExistingUser()) {
				error("The credentials you entered already belongs to an existing user");
				return null;
		}
		
		//3.a Verify the GP
		if(user.getRole().equals("Doctor") && !isVerifiedGP()){
			System.out.println("GP Verification failed. Valid License Number ranges from 300000000 to 300090000");
			error("We are not able to verify your GP qualification");
			return null;
		}
		
		//3.b Verify Pharmacist
		if(user.getRole().equals("Pharmacist") && !isVerifiedPharmacist()){
			System.out.println("Pharmacist Verification failed. Valid License Number ranges from 600000000 to 600090000");
			error("We are not able to verify your Pharmacist qualification");
			return null;
		}
		

		// 4. Add the attributes from the userBean to the User object
		addUserAttributes();
		
		
		//5. Add the new user to the User's List
		registry.addUser(user);
		
		
		/*success("Registration successul" + "&nbsp;<a href='login.jsf'>Login</a>");*/
		
		System.out.println("New List of Users");
		
		for(User existingUser : registry.getUsers()) {
			System.out.println(existingUser);
		}
		
		
		//6. Redirect the user to Login page, faces-redirect changes the URl to login.jsf
		return "login?faces-redirect=true";
	}
		
	
	
	// Password validation
	private boolean passwordsMatch() {
		return userBean.getPassword().equals(userBean.getPasswordConfirmation());
	}
	
	
	// Existing user validation
	private boolean isExistingUser() {
		for(User existingUser : registry.getUsers()) {
			if(existingUser.getTheEmail().equalsIgnoreCase(userBean.getEmail())) {
				return true;
			}	
			if(existingUser.getTheID() == userBean.getLicenseNumber()) {
				return true;
			}
		}
		return false;
	}
	
	// GP verification
	private boolean isVerifiedGP() {
		return userBean.getLicenseNumber() >= 300000000 && userBean.getLicenseNumber() <= 399999999;
	}
	
	// Pharmacist verification
	private boolean isVerifiedPharmacist() {
		return userBean.getLicenseNumber() >= 600000000 && userBean.getLicenseNumber() <= 699999999;	
	}
	
	
	// Add userBean attributes to user instance
	private void addUserAttributes() {
		user.setThePassword(userBean.getPassword());
		user.setTheName(userBean.getName());
		user.setTheEmail(userBean.getEmail());
		user.setTheAddress(userBean.getAddress());
		
		
		// set the user id
		if(userBean.getRole().equals("Patient")) {
			List<User> users = registry.getUsers();
			
			for(int i = users.size()-1; i >= 0; i--) {
				if(registry.getUsers().get(i).getRole().equals("Patient")) {
					user.setTheID(registry.getUsers().get(i).getTheID() + 1);
					return;
				}
			}
		}else {
			user.setTheID(userBean.getLicenseNumber());
		}
	}
	
	// Helper methods for notification   
    private void error(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
    }
    
    private void success(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", message));
    }
     
}
