package com.ait.drcare.managedbeans.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.model.Medicine;
import com.ait.drcare.model.PrescriptionItem;

class PrescriptionItemTest {

	
	private Medicine medicine;
	private PrescriptionItem prescriptionItem;

	
	@BeforeEach
	void setUp() throws Exception {
		prescriptionItem = new PrescriptionItem();
	}

	@Test
	void testConstructor() {
		medicine = new Medicine();
		prescriptionItem = new PrescriptionItem(medicine,20.2,3);
		assertEquals(medicine,prescriptionItem.getMedicine());
		assertEquals(20.2,prescriptionItem.getDosagePerDay());
		assertEquals(3, prescriptionItem.getDuration());
	}
	
	@Test
	void testGettersSetters() {
		
		medicine = new Medicine();
		medicine.setTheName("med");

		prescriptionItem.setMedicine(medicine);
		prescriptionItem.setDosagePerDay(202.2);
		prescriptionItem.setDuration(1);
		prescriptionItem.setNotefromPharmacist("note");
		prescriptionItem.setQuantity(5);
		prescriptionItem.setSubtotal(4);
		
		assertEquals(medicine, prescriptionItem.getMedicine());
		assertEquals("med",prescriptionItem.getMedicineName());
		assertEquals(202.2,prescriptionItem.getDosagePerDay());
		assertEquals(1,prescriptionItem.getDuration());
		assertEquals("note",prescriptionItem.getNotefromPharmacist());
		

		
		
	}

}
