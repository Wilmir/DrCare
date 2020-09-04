package com.ait.drcare.managedbeans.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Prescription;

class PatientInfoControllerTest {

	private PatientInfoController patientInfoController;
	
	@BeforeEach
	public void setUp() {
		patientInfoController = new PatientInfoController();
	}
	
	
	@Test
	@Disabled // Not possible to test due to the absence of FacesContext. Will test this manually.
	public void testInitMethod() {
	}

	
	@Test
	public void testSetUserEmail() {
		patientInfoController.setUserEmail("test@drcare.ie");
		
		assertEquals("test@drcare.ie", patientInfoController.getUserEmail());
	}
	
	@Test
	public void testSetCurrentUser() {
		// Patient(String name,int ID,String Password,String Email,ArrayList<String> Allergies,String medicalCard,String address)
		Patient patient = new Patient("Test User",1353,"password", "test@drcare.ie", new ArrayList<>(),"medicalCard", "Athlone");
		
		patientInfoController.setCurrentUser(patient);
		
		
		assertEquals("Test User", patientInfoController.getCurrentUser().getTheName());
		assertEquals(1353, patientInfoController.getCurrentUser().getTheID());
		assertEquals("test@drcare.ie", patientInfoController.getCurrentUser().getTheEmail());
		assertEquals("password", patientInfoController.getCurrentUser().getThePassword());
		assertEquals("medicalCard", patientInfoController.getCurrentUser().getTheMedicalCardNumber());
		assertEquals("Athlone", patientInfoController.getCurrentUser().getTheAddress());
	}
	
	
	@Test
	public void testSetPatients() {
		// Patient(String name,int ID,String Password,String Email,ArrayList<String> Allergies,String medicalCard,String address)
		Patient patient1 = new Patient();
		Patient patient2 = new Patient();
		Patient patient3 = new Patient();
		
		ArrayList<Patient> patients =  new ArrayList<>();
			patients.add(patient1);
			patients.add(patient2);
			patients.add(patient3);
			
		patientInfoController.setPatients(patients);
			

		assertEquals(3, patientInfoController.getPatients().size());
	}
	
	@Test
	public void testSetPrescriptions() {
		// Patient(String name,int ID,String Password,String Email,ArrayList<String> Allergies,String medicalCard,String address)
		Prescription prescription1 = new Prescription();
		Prescription prescription2 = new Prescription();
		Prescription prescription3 = new Prescription();
		
		ArrayList<Prescription> prescriptions =  new ArrayList<>();
			prescriptions.add(prescription1);
			prescriptions.add(prescription2);
			prescriptions.add(prescription3);
			
		patientInfoController.setPrescriptions(prescriptions);
			
		assertEquals(3, patientInfoController.getPrescriptions().size());
	}
	
	
	@Test
	public void testPay() {
		assertEquals("paypal?faces-redirect=true", patientInfoController.pay());
	}

}
