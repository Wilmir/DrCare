package com.ait.drcare.managedbeans.backing.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.managedbeans.backing.PatientBean;
import com.ait.drcare.model.Prescription;

class PatientBeanTest {

	private PatientBean pbean;
	private Prescription p = new Prescription();
	private ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
	
	@BeforeEach
	void setUp() throws Exception {
		pbean = new PatientBean();
}

	@Test
	void testGettersAndSetters() {
		pbean.setCurrentPrescription(p);
		assertEquals(p,pbean.getCurrentPrescription());
		
		pbean.setName("namus");
		assertEquals("namus",pbean.getName());
		
		pbean.setId(2);
		assertEquals(2,pbean.getId());
		
		pbean.setEmail("email@email");
		assertEquals("email@email",pbean.getEmail());
		
		pbean.setPrescriptions(prescriptions);
		assertEquals(prescriptions,pbean.getPrescriptions());
	}

}
