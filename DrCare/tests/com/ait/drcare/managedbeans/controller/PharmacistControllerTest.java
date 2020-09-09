package com.ait.drcare.managedbeans.controller;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ait.drcare.managedbeans.controller.PharmacistController;
import com.ait.drcare.model.Prescription;

@Disabled
class PharmacistControllerTest {

	PharmacistController pController = new PharmacistController();
	Prescription prescription = new Prescription();
	ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testDispense() {
		pController.updateStatus(prescription);
		assertEquals("Order Dispenced",prescription.getTheStatus());
	}
	
	@Test
	void testSaveChanges() {
		
		
	}
	@Test
	void testGettersAndSetters() {
		assertEquals("",pController.getTheUserEmail());
		pController.setPrescriptions(prescriptions);
		assertEquals(prescriptions,pController.getPrescriptions());
		pController.setTheUserEmail("Em");
		assertEquals("Em",pController.getTheUserEmail());
		
		ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
		assertEquals(prescriptions, pController.getPrescriptions());
		assertEquals("ok",pController.getPrescriptionEdit(prescription));
		
	}

}
