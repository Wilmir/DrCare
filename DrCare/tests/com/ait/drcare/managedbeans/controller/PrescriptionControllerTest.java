package com.ait.drcare.managedbeans.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ait.drcare.managedbeans.backing.PrescriptionBean;
import com.ait.drcare.model.Prescription;

class PrescriptionControllerTest {

	PrescriptionController pController = new PrescriptionController();
	ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
	
	DoctorController currentDoctor = new DoctorController();
	PrescriptionBean prescripBean = new PrescriptionBean();
	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void testAddNewPrescription() {
		
		prescriptions = pController.getPrescriptions();
		
		assertEquals(prescriptions,pController.getPrescriptions());
	}

}
