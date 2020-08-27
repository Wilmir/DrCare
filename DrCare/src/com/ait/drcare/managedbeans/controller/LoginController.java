package com.ait.drcare.managedbeans.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.backing.UserLoginBean;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.User;

@ManagedBean
@RequestScoped
public class LoginController {

	private UserLoginBean userLoginBean;
	private UserListBean existingUsers;
	private String message = "";
	private final String ROLE_PATIENT = "Patient", ROLE_PHARMACIST = "Pharmacist", ROLE_DOCTOR = "Doctor";

	@PostConstruct
	public void init() {
		userLoginBean = Helper.getBean("userLoginBean", UserLoginBean.class);
		existingUsers = Helper.getBean("userListBean", UserListBean.class);
	}
	
	public void setUserBean(UserLoginBean userBean) {
		this.userLoginBean = userBean;
	}

	public void setExistingUsers(UserListBean existingUsers) {
		this.existingUsers = existingUsers;
	}

	public String validateUserLogin() {
		String givenUser = userLoginBean.getEmail();
		String givenPassword = userLoginBean.getPassword();
		User registeredUser = new User();
		boolean userFound = false;

		for (User existingUser : existingUsers.getUsers()) {
			if (existingUser.getTheEmail().equalsIgnoreCase(givenUser)) {
				registeredUser = existingUser;
				userFound = true;
			}

		}
		// if no user exists
		if (!userFound) {
			message = "The given user is not registed in the System. Please Register";
			System.out.println(message);
			return null;
		}
		// If account is locked
		if (registeredUser.getAccountLock()) {
			message = "Account Locked";
			System.out.println(message);
			return null;
		}

		// If user's login is successful
		if (givenPassword.equals(registeredUser.getThePassword())) {
			message = "Login Successfull";
			System.out.println(message);
			registeredUser.resetFailedAttempts();

			//Add user attribute to session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", registeredUser.getTheEmail());

			// if user is a patient
			if (registeredUser.getRole().equals("Patient")) {
				System.out.println("Patient Recognised, sending to patient page");
				return "patient?faces-redirect=true";
			}

			// if user is a gp
			if (registeredUser.getRole().equals("Doctor")) {
				System.out.println("GP Recognised, sending to GP page");
				
				return "doctor?faces-redirect=true";
			}

			// if user is a pharmacist
			if (registeredUser.getRole().equals("Pharmacist")) {
				System.out.println("Pharmacist Recognised, sending to Pharmacist page");
				return "pharmacist?faces-redirect=true";
			}

			return "wut";
		}

		// Track number of logins
		else {
			 registeredUser.setFailedAttempts();
			 if (registeredUser.getFailedAttempts() >= 5) {
				System.err.println("Login Failed !! Account Locked as no.of retries exceeded 5");
				registeredUser.setAccountLock(true);
			} 
			else {
				System.err.println("Login Failure !!");
				}
		}

		// End function if all else fails
		return null;

	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login?faces-redirect=true";
	}
}
