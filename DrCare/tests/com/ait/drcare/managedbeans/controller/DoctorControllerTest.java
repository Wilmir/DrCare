package com.ait.drcare.managedbeans.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Prescription;

class DoctorControllerTest {

	private DoctorController doctorController;
	private UserListBean dataStore;
	private ArrayList<Prescription> prescriptions;
	
	@BeforeEach
	void setUp() throws Exception {
		doctorController = new DoctorController();
		dataStore = new UserListBean();
		prescriptions = new ArrayList<Prescription>();
	}

	
	
	@Test
	void tesSettersAndGetters() {
		Patient patient = new Patient();
		doctorController.setCurrentPatient(patient);
		assertEquals(patient,doctorController.getCurrentPatient());
		Prescription p = new Prescription();
		doctorController.setCurrentPrescription(p);
		assertEquals(p,doctorController.getCurrentPrescription());
		
		ArrayList<String> allergies = new ArrayList<String>();
		doctorController.setAllergies(allergies);
		assertEquals(allergies,doctorController.getAllergies());
		
		//getPrescriptions Untestable as relies on the datastorage
		
	}

}
