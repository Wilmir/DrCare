package com.ait.drcare.managedbeans.backing.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.managedbeans.backing.PrescriptionBean;
import com.ait.drcare.model.Medicine;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Pharmacist;
import com.ait.drcare.model.PrescriptionItem;

//PrescriptionBean is used to store selected values by the doctor
class PrescriptionBeanTest {

	private PrescriptionBean pbean;
	private  ArrayList<PrescriptionItem> items;
	
	@BeforeEach
	void setUp() throws Exception {
		
		pbean = new PrescriptionBean();
		items = new ArrayList<PrescriptionItem>();
	}

	@Test
	void testGettersAndSetters() {
		Patient patient = new Patient();
		pbean.setPatient(patient);
		assertEquals(patient, pbean.getPatient());	
		
		Pharmacist pharmacist = new Pharmacist();
		pbean.setPharmacist(pharmacist);
		assertEquals(pharmacist, pbean.getPharmacist());
		
		Medicine medicine = new Medicine();
		pbean.setMedicine(medicine);
		assertEquals(medicine, pbean.getMedicine());
		
		pbean.setDosage(12.2);
		assertEquals(12.2, pbean.getDosage());
		pbean.setDuration(2);
		assertEquals(2,pbean.getDuration());
		
		pbean.setTheNote("hi");
		assertEquals("hi",pbean.getTheNote());
		
		pbean.setPrescriptionItems(items);
		assertEquals(0,pbean.getPrescriptionItems().size());
		PrescriptionItem pItem = new PrescriptionItem();
		items.add(pItem);
		pbean.setPrescriptionItems(items);
		assertEquals(1,pbean.getPrescriptionItems().size());
		
		pbean.setQuantity(2);
		assertEquals(2,pbean.getQuantity());
		Object emp = new Object();
		pbean.setPlaceholder(emp);
		assertEquals(emp, pbean.getPlaceholder());
	}

}
