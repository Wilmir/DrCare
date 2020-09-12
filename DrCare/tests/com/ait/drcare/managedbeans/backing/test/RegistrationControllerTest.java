package com.ait.drcare.managedbeans.backing.test;

import static org.junit.Assert.*;
import com.ait.drcare.managedbeans.backing.UserBean;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.managedbeans.controller.RegistrationController;

import org.junit.Before;
import org.junit.Test;

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
	public void registerDoctorWithCorrectDetails() {
		UserBean userBean = new UserBean();
		userBean.setName("Alan Care");
		userBean.setAddress("Athlone");
		userBean.setEmail("alancare@doc.ie");
		userBean.setPassword("abc");
		userBean.setPasswordConfirmation("abc");
		userBean.setRole("GP");
		userBean.setLicenseNumber(300000005);
		
		assertEquals("index?faces-redirect=true", regController.addUser(userBean));
	}
	
	@Test
	public void registerPharmacistWithCorrectDetails() {
		UserBean userBean = new UserBean();
		userBean.setName("Joe Curly");
		userBean.setAddress("Athlone");
		userBean.setEmail("joecurly@pharmacist.ie");
		userBean.setPassword("abc");
		userBean.setPasswordConfirmation("abc");
		userBean.setRole("Pharmacist");
		userBean.setLicenseNumber(600000005);
		
		assertEquals("index?faces-redirect=true", regController.addUser(userBean));
	}
	
	@Test
	public void registerPatientWithCorrectDetails() {
		UserBean userBean = new UserBean();
		userBean.setName("Ross Common");
		userBean.setAddress("Athlone");
		userBean.setEmail("ross@patient.ie");
		userBean.setPassword("abc");
		userBean.setPasswordConfirmation("abc");
		userBean.setRole("Patient");
		
		assertEquals("index?faces-redirect=true", regController.addUser(userBean));
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
