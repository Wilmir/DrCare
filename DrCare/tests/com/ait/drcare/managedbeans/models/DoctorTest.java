package com.ait.drcare.managedbeans.models;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.model.Doctor;
import com.ait.drcare.model.Patient;

class DoctorTest {

	private Doctor doc;
	@BeforeEach
	void setUp() throws Exception {
		 doc = new Doctor("Brian Brown", 0002345,"passW@rd", "DrBrianBrown@Health.com",
				"0876792256","Ash Lane, Bog Street, County");
	}

	@Test // 1-1 Constructor
	void testDoctorConstructor() {
		Doctor docococo = new Doctor();
		assertEquals("Doctor",docococo.getRole());
		
		assertEquals("Brian Brown",doc.getTheName());
		assertEquals(0002345,doc.getTheID());
		assertEquals("passW@rd",doc.getThePassword());
		assertEquals("DrBrianBrown@Health.com",doc.getTheEmail());
		assertEquals("0876792256",doc.getPhoneNumber());
		assertEquals("Ash Lane, Bog Street, County",doc.getTheAddress());
	
	}

	@Test //1-2
	void testDoctorGettersAndSetter() {
		
		doc.setAccountLock(false);
		assertFalse(doc.getAccountLock());
		doc.setAccountLock(true);
		assertTrue(doc.getAccountLock());
		
		doc.setTheName("Jon");
		doc.setPhoneNumber("39i41010");
		doc.setRole("Doctr");
		doc.setTheAddress("Somewhere");
		doc.setTheEmail("email");
		doc.setTheID(2222);
		doc.setThePassword("pass");
		
		
		assertEquals("Jon",doc.getTheName());
		assertEquals("39i41010",doc.getPhoneNumber());
		assertEquals("Doctr",doc.getRole());
		assertEquals("Somewhere",doc.getTheAddress());
		assertEquals("email",doc.getTheEmail());
		assertEquals("pass",doc.getThePassword());
		
		
		
	}

}
