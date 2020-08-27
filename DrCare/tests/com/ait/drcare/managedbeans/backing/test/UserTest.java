package com.ait.drcare.managedbeans.backing.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.model.User;

class UserTest {
	
	
	User u1 = new User();
	User u2 = new User("U", 2323,"Upass","U@U", "Ustreet", "Unknown");
	
	@BeforeEach
	void setUp() {
		u1.setTheName("bob");
	
	}
	
	
	@Test
	void testVariableSetting() {
		
		assertEquals("bob",u1.getTheName());
		
		u1.setTheID(2345);
		assertEquals(2345,u1.getTheID());
		
		u1.setThePassword("MacaDamia");
		assertEquals("MacaDamia",u1.getThePassword());
		
		u1.setTheEmail("Maca@Maca");
		assertEquals("Maca@Maca",u1.getTheEmail());
		
		u1.setRole("Patient");
		assertEquals("Patient",u1.getRole());
	}
	
	@Test
	void testForFailedAttempts() {
		u1.setFailedAttempts();
		assertEquals(1,u1.getFailedAttempts());
		assertFalse(u1.getAccountLock());
		
		u1.resetFailedAttempts();
		assertEquals(0,u1.getFailedAttempts());
		
		u1.setTheAddress("123 road");
		assertEquals("123 road",u1.getTheAddress());
	}
	
	@Test
	void testForLockedAccount() {
		u1.setAccountLock(false);
		assertFalse(u1.getAccountLock());
	}
	
	
	@Test
	void enableCanEdit() {	 
		u1.setCanEdit(true);
		assertTrue(u1.isCanEdit());
	}
	
}
