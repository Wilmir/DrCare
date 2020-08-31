package com.ait.drcare.managedbeans.controller;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.ait.drcare.managedbeans.backing.UserLoginBean;
import com.ait.drcare.managedbeans.controller.LoginController;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.User;

@DisplayName("LoginControllerTest: Given the user logs in")
class LoginControllerTest {
    
    private LoginController loginController;
	private UserListBean existingUsers;
	private UserLoginBean userBean;
	
	@BeforeEach
	public void setUp() {		

		loginController = new LoginController();
		existingUsers = new UserListBean();
		existingUsers.init();
		loginController.setExistingUsers(existingUsers);
		userBean = new UserLoginBean();
		loginController.setUserBean(userBean);
		
	}
		
	
	@Nested
	@Disabled // Not Possible to Test Due to FacesContext dependency
	@DisplayName("When, a registered user supplied the correct credentials")
	class SuccessfulLogin{
		
		@Test
		@DisplayName("Then, the GP should be able to login")
		public void testSuccesfulRegistrationGP() {				
			userBean.setEmail("alan@drcare.ie");
			userBean.setPassword("passw0rd");
			
			assertEquals("doctor?faces-redirect=true", loginController.validateUserLogin());
		}
		
		
		@Test
		@DisplayName("Then, the Pharmacist should be able to login")
		public void testSuccesfulRegistrationPharmacist() {
			userBean.setEmail("B");
			userBean.setPassword("B");
			
			assertEquals("pharmacist?faces-redirect=true", loginController.validateUserLogin());
		}
		
		
		@Test
		@DisplayName("Then, the Patient should be able to login")
		public void testSuccesfulRegistrationPatient() {
			userBean.setEmail("johndoe@gmail.com");
			userBean.setPassword("password234");
			
			assertEquals("patient?faces-redirect=true", loginController.validateUserLogin());
		}
		
	}
	

	
	@Nested
	@DisplayName("When, a registered user supplied the incorrect credentials")
	class RegisteredUserFailedLogin{
		@Test
		@DisplayName("Then, one failed attempt sets the users failedAttempt count to 1")
		public void testFailedLoginWrongPasswordOneFailedAttemptIncrement() {
			userBean.setEmail("johndoe@gmail.com");
			userBean.setPassword("password999");
			
			User registeredUser = null;
			for(User user : existingUsers.getUsers()) {
				if(user.getTheEmail().equalsIgnoreCase(userBean.getEmail())) {
					registeredUser = user;
					break;
				}
			}
			
			loginController.validateUserLogin();
			
			assertEquals(1, registeredUser.getFailedAttempts());
		}


		@Test
		@DisplayName("Then, two failed attempt sets the users failedAttempt count to 2")
		public void testFailedLoginWrongPasswordTwoFailedAttemptIncrement() {
			userBean.setEmail("johndoe@gmail.com");
			userBean.setPassword("password999");
			
			User registeredUser = null;
			for(User user : existingUsers.getUsers()) {
				if(user.getTheEmail().equalsIgnoreCase(userBean.getEmail())) {
					registeredUser = user;
					break;
				}
			}
			
			loginController.validateUserLogin();
			
			loginController.validateUserLogin();

			assertEquals(2, registeredUser.getFailedAttempts());
		}

		
		@Test
		@DisplayName("Then, five failed attempt sets the users failedAttempt count to 5")
		public void testFailedLoginWrongPasswordFiveFailedAttemptIncrement() {
			userBean.setEmail("johndoe@gmail.com");
			userBean.setPassword("password999");
			
			User registeredUser = null;
			for(User user : existingUsers.getUsers()) {
				if(user.getTheEmail().equalsIgnoreCase(userBean.getEmail())) {
					registeredUser = user;
					break;
				}
			}
			
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			loginController.validateUserLogin();


			assertEquals(5, registeredUser.getFailedAttempts());
		}
		
		
		
		@Test
		@DisplayName("Then, five failed attempt locks the users account")
		public void testFailedLoginWrongPasswordFiveFailedAttemptLocksAccount() {
			userBean.setEmail("johndoe@gmail.com");
			userBean.setPassword("password999");
			
			User registeredUser = null;
			for(User user : existingUsers.getUsers()) {
				if(user.getTheEmail().equalsIgnoreCase(userBean.getEmail())) {
					registeredUser = user;
					break;
				}
			}
			
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			loginController.validateUserLogin();


			assertTrue(registeredUser.getAccountLock());
		}
		
		@Test
		@DisplayName("Then, a locked account will bot be able to login")
		public void testFailedLoginWrongPasswordSevenFailedAttemptIncrement() {
			userBean.setEmail("johndoe@gmail.com");
			userBean.setPassword("password999");
			
			User registeredUser = null;
			for(User user : existingUsers.getUsers()) {
				if(user.getTheEmail().equalsIgnoreCase(userBean.getEmail())) {
					registeredUser = user;
					break;
				}
			}
			
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			
			assertEquals(null, loginController.validateUserLogin());
		}

	}
	
	
	@Nested
	@Disabled // Not Possible to Test Due to FacesContext dependency.
	@DisplayName("When, a registered user initially supplied incorrect credentials")
	class RegisteredUserFailedAndSuccesffulLogin{
		
		@Test
		@DisplayName("Then, supplying correct credentials lead to successful login")
		public void testFailedLoginWrongPasswordOneFailedandTheSuccesfulAttemptOne() {
			userBean.setEmail("johndoe@gmail.com");
			userBean.setPassword("password999");
			
			User registeredUser = null;
			for(User user : existingUsers.getUsers()) {
				if(user.getTheEmail().equalsIgnoreCase(userBean.getEmail())) {
					registeredUser = user;
					break;
				}
			}
			
			loginController.validateUserLogin();
			
			//supplies the correct password afterwards
			userBean.setPassword("password234");
			
			assertEquals("patient?faces-redirect=true", loginController.validateUserLogin());
		}
		
		@Test
		@DisplayName("Then, supplying correct credentials should reset the failedAttempts to zero")
		public void testFailedLoginWrongPasswordOneFailedandTheSuccesfulAttemptTwo() {
			userBean.setEmail("johndoe@gmail.com");
			userBean.setPassword("password999");
			
			User registeredUser = null;
			for(User user : existingUsers.getUsers()) {
				if(user.getTheEmail().equalsIgnoreCase(userBean.getEmail())) {
					registeredUser = user;
					break;
				}
			}
			
			// three failed attempts
			loginController.validateUserLogin();
			loginController.validateUserLogin();
			loginController.validateUserLogin();

			
			// user then supplied the correct password afterwards
			userBean.setPassword("password234");

			loginController.validateUserLogin();			
			
			assertEquals(0, registeredUser.getFailedAttempts());
		}

	}
	
	
	@Nested
	@DisplayName("When an unregistered user supplies their credentials")
	class UnRegisteredUserUserLogIn{
		
		@Test
		@DisplayName("Then, the login should fail")
		public void testFailedLoginUserNotFound() {
			userBean.setEmail("inexistentuser@gmail.com");
			userBean.setPassword("password1234");
			
			assertEquals(null, loginController.validateUserLogin());
		}
		
	}
	

	 @Test
	 @Disabled 	// Cannot test logout: Validation of SessionMap clearance is not possible with JUnit*/
	 @DisplayName("When a user logs out, then the session map should be cleared.")
	 public void testLogOut() {
		 assertEquals("login?faces-redirect=true", loginController.logout());
	 }
	
	 

}
