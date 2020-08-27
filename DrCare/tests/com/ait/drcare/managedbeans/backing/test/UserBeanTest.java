package com.ait.drcare.managedbeans.backing.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ait.drcare.managedbeans.backing.UserBean;

public class UserBeanTest {
	
	private UserBean user=new UserBean();

	@Before
	public void setUp() throws Exception {
		
		user.setName("User");
		user.setEmail("aaa@ait.ie");
		user.setAddress("athlone");
		user.setLicenseNumber(535478);
		user.setPassword("pwd");
		user.setPasswordConfirmation("pwd");
		user.setRole("doctor");
		
	}

	@Test
	public void test() {
		
		assertEquals("User",user.getName());
		assertEquals("aaa@ait.ie",user.getEmail());
		assertEquals("athlone",user.getAddress());
		assertEquals(535478,user.getLicenseNumber());
		assertEquals("pwd",user.getPassword());
		assertEquals("pwd",user.getPasswordConfirmation());
		assertEquals("doctor",user.getRole());
	}

}
