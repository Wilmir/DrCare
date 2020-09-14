package com.ait.drcare.managedbeans.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.model.Medicine;

class MedicineTest {

	
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test //1-1 Test Empty Constructor
	void testConstructor() {
		Medicine medicine1 = new Medicine();
		assertEquals(0, medicine1.getTheContents().size());
		assertEquals(0, medicine1.getTheSideEffects().size());
		
	}
	
	@Test //Test Paramaters Constructor
	void testConstructorParamater() {
		Medicine medicine2 = new Medicine("Paracetamol","Strong",20.20);
		assertEquals("Paracetamol", medicine2.getTheName());
		assertEquals("Strong", medicine2.getStrength());
		assertEquals(20.20, medicine2.getTheUnitPrice());	
	}

	@Test //Test getters and setters
	void testMedicineGettersAndSetters() {
		Medicine medicine = new Medicine();
		medicine.setTheName("Medi");
		assertEquals("Medi", medicine.getTheName());
		medicine.setStrength("Weak");
		assertEquals("Weak", medicine.getStrength());
		Date expiraryDate = new Date(1,4,2020);
		medicine.setTheExpiryDate(expiraryDate);
		assertEquals(expiraryDate, medicine.getTheExpiryDate());
		medicine.setTheUnitPrice(19.34);
		assertEquals(19.34, medicine.getTheUnitPrice());
		
	}
	
	@Test // 2-1 Test get set Contents
	void testForMedicineContents() {
		
	}
	
	@Test //2-2 Test get set for SideEffects
	void testForSideEffects() {
		
	}
	
}
