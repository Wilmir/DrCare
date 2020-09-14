package com.ait.drcare.managedbeans.backing.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.managedbeans.backing.DoctorBean;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Doctor;
import com.ait.drcare.model.Patient;

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

}
