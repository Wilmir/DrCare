package com.ait.drcare.managedbeans.backing.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.managedbeans.backing.PharmacistBean;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Pharmacist;
import com.ait.drcare.model.Prescription;
import com.ait.drcare.model.User;

class PharmacistBeanTest {

	private PharmacistBean pharmacistBean;
	private UserListBean dataStore;
	
	@BeforeEach
	public void setUp() {
		pharmacistBean = new PharmacistBean();
		dataStore = new UserListBean();
	}

	@Test
	void testSetCurrentUser() {
		// User(String name, int ID, String password,String email,String address, String role)
		Pharmacist pharmacist = new Pharmacist("Wilmir Nicanor", 30000001, "password", "wilmir@google.com", "Athlone, Ireland");
		
		pharmacistBean.setCurrentUser(pharmacist);
		
		assertEquals("wilmir@google.com", pharmacistBean.getCurrentUser().getTheEmail());	
	}
	
	@Test
	void testCurrentPrescription() {
		Prescription prescription = new Prescription();
		prescription.setTheStatus(Prescription.PRESCRIPTION_READY_FOR_PICKUP);
		
		pharmacistBean.setCurrentPrescription(prescription);
		
		assertEquals("Ready for pickup", pharmacistBean.getCurrentPrescription().getTheStatus());
		assertFalse(pharmacistBean.isPreview());
	}
	
	
	
}
