package com.ait.drcare.managedbeans.backing.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.managedbeans.backing.DoctorBean;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Doctor;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Prescription;

class DoctorBeanTest {

	private DoctorBean doctorBean;
	private UserListBean dataStore;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		doctorBean = new DoctorBean();
		dataStore = new UserListBean();
	}

	@Test
	void testSetCurrentUser() {
		Doctor doc = new Doctor("Dr Doc",202011,"Password","Doctor@Doctor.dr","087338972","Doctor Office dr");
		
		doctorBean.setDoctor(doc);
		assertEquals(doc,doctorBean.getDoctor());
	}
	
	@Test
	void testSetCurrentPatient() {
		Patient patient = new Patient();
		doctorBean.setCurrentPatient(patient);
		
		assertEquals(patient, doctorBean.getCurrentPatient());
	}
	
	@Test
	void testGettersAndSetters() {
		Prescription prescription  = new Prescription();
		doctorBean.setCurrentPrescription(prescription);
		assertEquals(prescription,doctorBean.getCurrentPrescription());
		
		String qry =  "try this";
		doctorBean.setQuery(qry);
		assertEquals(qry, doctorBean.getQuery());
		
		int searchResult = 25;
		
		int patientsSize = 5;
		
		
		Patient p = new Patient();
		Patient p2 = new Patient();
		ArrayList<Patient> patients  = new ArrayList<>();
		patients.add(p);
		patients.add(p2);
		doctorBean.setPatients(patients);
		assertEquals(patients,doctorBean.getPatients());
		assertEquals(2,doctorBean.getSearchResultSize());
		doctorBean.setSearchResultSize(searchResult);
		
	}

}
