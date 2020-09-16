package com.ait.drcare.managedbeans.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.backing.UserBean;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Doctor;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Pharmacist;
import com.ait.drcare.model.User;

@ManagedBean
@RequestScoped
public class RegistrationController {
	
	private UserListBean registry;
		
	@PostConstruct
	public void init() {
		registry = Helper.getBean("userListBean", UserListBean.class);
	}

	
	public String addUser(UserBean userBean) {
		// 1. Check if the passwords entered match
		if(!passwordsMatch(userBean)){
			error("The passwords entered do not match");
			return null;
		}
		
		// 2. Check if user is not existing		
		if(isExistingUser(userBean)) {
				error("The credentials you entered already belongs to an existing user");
				return null;
		}
		
		//3.a Verify the GP
		if(userBean.getRole().equals("GP") && !isVerifiedGP(userBean)){
			System.out.println("GP Verification failed. Valid License Number ranges from 300000000 to 300090000");
			error("We are not able to verify your GP qualification");
			return null;
		}
		
		//3.b Verify Pharmacist
		if(userBean.getRole().equals("Pharmacist") && !isVerifiedPharmacist(userBean)){
			System.out.println("Pharmacist Verification failed. Valid License Number ranges from 600000000 to 600090000");
			error("We are not able to verify your Pharmacist qualification");
			return null;
		}
		

		// 4. Add the attributes from the userBean to a new User object
		addToRegistry(userBean);
	
		success("Registration successful");
		
		System.out.println("New List of Users");
		
		for(User existingUser : registry.getUsers()) {
			System.out.println(existingUser);
		}
		
		
		//5. Redirect the user to Login page, faces-redirect changes the URl to login.jsf
		return null;
	}

	// Password validation
	private boolean passwordsMatch(UserBean userBean) {
		return userBean.getPassword().equals(userBean.getPasswordConfirmation());
	}
	
	
	// Existing user validation
	private boolean isExistingUser(UserBean userBean) {
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
	private boolean isVerifiedGP(UserBean userBean) {
		System.out.println(userBean.getLicenseNumber());
		return userBean.getLicenseNumber() >= 300000000 && userBean.getLicenseNumber() <= 399999999;
	}
	
	// Pharmacist verification
	private boolean isVerifiedPharmacist(UserBean userBean) {
		return userBean.getLicenseNumber() >= 600000000 && userBean.getLicenseNumber() <= 699999999;	
	}
	
	// Add the userBean to the list of registered users
	private void addToRegistry(UserBean userBean) {
		// Declare a new user object
		User user;
				
		// instantiate a user depending on the role
		switch(userBean.getRole()) {
			case "GP":
				user = new Doctor();
				break;
			case "Pharmacist":
				user = new Pharmacist();
				registry.getPharmacists().add((Pharmacist) user);
				break;
			default:
				user = new Patient();
				registry.getPatients().add((Patient) user);
				break;
		}
				
		// pass the remaining attributes of userBean to the user object
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
					break;
				}
			}
		}else {
			user.setTheID(userBean.getLicenseNumber());
		}
				
		// Add the new user to the User's List
		registry.addUser(user);
	}
	
	public UserListBean getRegistry() {
		return registry;
	}

	public void setRegistry(UserListBean registry) {
		this.registry = registry;
	}

	// Helper methods for notification   
    private void error(String message) {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        if(currentInstance != null) {
            currentInstance.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
        }
    }
    
    private void success(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", message));
    }
     
}
