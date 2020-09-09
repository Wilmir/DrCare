package com.ait.drcare.managedbeans.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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
			printMessage(givenUser, "The given user is not registered in the System. Please Register" );
			System.out.println(message);
			return null;
		}
		// If account is locked
		if (registeredUser.getAccountLock()) {
			message = "Account Locked";
			System.out.println(message);
			printMessage(givenUser, message);

			return null;
		}

		// If user's login is successful
		if (givenPassword.equals(registeredUser.getThePassword())) {
			message = "Login Successfull";
			System.out.println(message);
			registeredUser.resetFailedAttempts();

			//Add user attribute to session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", registeredUser.getTheEmail());
			System.out.println("The user list bean points to " + existingUsers.hashCode());
			
			
			
			// if user is a patient
			if (registeredUser.getRole().equals("Patient")) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("role", "Patient");
				System.out.println("Patient Recognised, sending to patient page");
				return "patient?faces-redirect=true";
			}

			// if user is a gp
			if (registeredUser.getRole().equals("Doctor")) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("role", "Doctor");
				System.out.println("GP Recognised, sending to GP page");
				
				return "doctor?faces-redirect=true";
			}

			// if user is a pharmacist
			if (registeredUser.getRole().equals("Pharmacist")) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("role", "Pharmacist");
				System.out.println("Pharmacist Recognised, sending to Pharmacist page");
				return "pharmacist?faces-redirect=true";
			}

			return "End of User check, You've taken a wrong turn";
		}

		// Track number of logins
		else {
			 registeredUser.setFailedAttempts();
			 if (registeredUser.getFailedAttempts() >= 5) {
				System.err.println("Login Failed !! Account Locked as no.of retries exceeded 5");
				printMessage(givenUser, "Login Failed !! Account Locked as no.of retries exceeded 5" );
				registeredUser.setAccountLock(true);
			} 
			else {
				System.err.println("Wrong password. Login Failure !!");
				printMessage(givenUser, "Wrong password. Try Again!!" );

				}
		}

		// End function if all else fails
		return null;

	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("role","");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", "");
		// FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login?faces-redirect=true";
	}
	
	// function prints messages for error handling
	public void printMessage(String user, String printline) {
		FacesMessage message =new FacesMessage (printline);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(user, message);
	}
}
