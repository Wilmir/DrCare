package com.ait.drcare.managedbeans.backing.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import com.ait.drcare.managedbeans.backing.UserBean;
import com.ait.drcare.managedbeans.controller.RegistrationController;
import com.ait.drcare.managedbeans.support.UserListBean;

public class RegistrationControllerTest {
	
	private RegistrationController regController;
	private UserListBean registry;
	
	@Before
	public void setUp() throws Exception {
		
		regController = new RegistrationController();
		registry = new UserListBean();
		registry.init();
		regController.setRegistry(registry);
	}


	
	@Test
	public void registerUserWithExistingEmail() {
		UserBean userBean = new UserBean();
		userBean.setName("Alan Care");
		userBean.setAddress("Athlone");
		userBean.setEmail("alan@drcare.ie");
		userBean.setPassword("abc");
		userBean.setPasswordConfirmation("abc");
		userBean.setRole("GP");
		
		assertNull(regController.addUser(userBean));
	}
	
	@Test
	public void registerUserWithExistingLicense() {
		UserBean userBean = new UserBean();
		userBean.setName("Alan Care");
		userBean.setAddress("Athlone");
		userBean.setEmail("alanasd@drcare.ie");
		userBean.setPassword("abc");
		userBean.setPasswordConfirmation("abc");
		userBean.setRole("GP");
		userBean.setLicenseNumber(1234);
		
		assertNull(regController.addUser(userBean));
	}
	
	@Test
	public void registerUserWithDifferentPasswords() {
		UserBean userBean = new UserBean();
		userBean.setName("Alan Care");
		userBean.setAddress("Athlone");
		userBean.setEmail("alanabc@drcare.ie");
		userBean.setPassword("abc");
		userBean.setPasswordConfirmation("abc123");
		userBean.setRole("GP");
		
		assertNull(regController.addUser(userBean));
	}
	
	@Test
	public void registerUserWithInavalidGPLicense() {
		UserBean userBean = new UserBean();
		userBean.setName("Alan Care");
		userBean.setAddress("Athlone");
		userBean.setEmail("alanabc@drcare.ie");
		userBean.setPassword("abc");
		userBean.setPasswordConfirmation("abc");
		userBean.setRole("GP");
		userBean.setLicenseNumber(400000000);
		
		assertNull(regController.addUser(userBean));
	}
	
	@Test
	public void registerUserWithInavalidPharmacistLicense() {
		UserBean userBean = new UserBean();
		userBean.setName("Alan Care");
		userBean.setAddress("Athlone");
		userBean.setEmail("alanabc@drcare.ie");
		userBean.setPassword("abc");
		userBean.setPasswordConfirmation("abc");
		userBean.setRole("Pharmacist");
		userBean.setLicenseNumber(700000000);
		
		assertNull(regController.addUser(userBean));
	}
	
	@Test
	public void getRegistry() {
		assertEquals(registry, regController.getRegistry());
	}

	
}
