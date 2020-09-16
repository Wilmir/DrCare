package com.ait.drcare.managedbeans.backing.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.managedbeans.support.MedicineListBean;
import com.ait.drcare.model.Medicine;

class MedicineListBeanTest {

	MedicineListBean MLB;
	
	@BeforeEach
	void setUp() throws Exception {
		MLB  = new MedicineListBean();
		MLB.init();
	}

	@Test
	void testMedicineList() {
		assertEquals(7, MLB.getMedications().size());
	}
	
	@Test
	void testGettersSetters() {
		assertEquals(10,MLB.getDosage());
		assertEquals(1,MLB.getDays());
		assertEquals(2,MLB.getTestDay());
		
		Medicine med = new Medicine();
		Medicine med2 = new Medicine();
		Medicine med3= new Medicine();
		Medicine med4 = new Medicine();
		
		ArrayList MedicineList = new ArrayList<Medicine>();
		MedicineList.add(med);
		MedicineList.add(med2);
		MedicineList.add(med3);
		MedicineList.add(med4);
		MLB.setMedications(MedicineList);
		assertEquals(MedicineList, MLB.getMedications());
	}

}
