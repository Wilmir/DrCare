package com.ait.drcare.managedbeans.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.model.Doctor;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Pharmacist;
import com.ait.drcare.model.Prescription;
import com.ait.drcare.model.PrescriptionItem;
import com.ait.drcare.model.Video;

class PrescriptionTest {

	private Prescription prescription1;
	private Prescription prescription2 = new Prescription();
	
	@BeforeEach
	void setUp() throws Exception {
	prescription1 = new Prescription();
	
	}

	@Test
	void testEmptyConstructor() {
	
		
		assertEquals("", prescription2.getTheNote());
		assertEquals("Waiting for payment",prescription2.getTheStatus());
		assertEquals("Waiting for payment",prescription2.getTheStatus());
		assertEquals(3,prescription2.getStatusValues().size());
		assertEquals("Waiting for payment",prescription2.getTheStatus());
		assertFalse(prescription2.isCanEditNote());
		
	}
	
	@Test
	void testFilledConstructor() {
		
		Patient patient =new Patient();
		Pharmacist pharmacist = new Pharmacist();
		Doctor doctor = new Doctor();
		
		
		prescription1.setThePharmacist(pharmacist);
		assertEquals(pharmacist,prescription1.getThePharmacist());
		prescription1.setThePharmacist(pharmacist);
		assertEquals(pharmacist,prescription1.getThePharmacist());
		prescription1.setTheDoctor(doctor);
		assertEquals(doctor,prescription1.getTheDoctor());
		prescription1.setThePatient(patient);
		assertEquals(patient,prescription1.getThePatient());
		
		//Patient patient, Pharmacist pharmacist, Doctor doctor
		prescription1 = new Prescription(patient,pharmacist,doctor);
				
		assertEquals(pharmacist,prescription1.getThePharmacist());
	}
	
	@Test
	void testGettersSetters() {
		prescription1.setCanEditNote(true);
		assertTrue(prescription1.isCanEditNote());
		
		prescription1.setTheStatus("Order Dispenced");
		assertEquals("Order Dispenced",prescription1.getTheStatus());
		prescription1.setTheDatePrescribed(new Date(1,2,2020));
	//	assertEquals(prescription1.getTheStatus());
		prescription1.setTheName("bobo");
		assertEquals("bobo",prescription1.getTheName());
		
		// test Getter and Setter for Videos
		ArrayList<Video> videos = new ArrayList<>();
		videos.add(new Video("id", "title"));
		prescription1.setVideos(videos);
		
	
		assertEquals("id", prescription1.getVideos().get(0).getId());
		assertEquals("title", prescription1.getVideos().get(0).getTitle());
		assertEquals(1, prescription1.getVideos().size());
		
		prescription1.setTheDatePrescribed(new java.util.Date(1, 2, 3));
		assertEquals(new Date(1,2,3), prescription1.getTheDatePrescribed());

		prescription1.setTheNote("Note");
		assertEquals("Note", prescription1.getTheNote());
		
		prescription1.setTotal(2020);
		assertEquals(2020,prescription1.getTotal());
		
		
	}
	
	@Test
	void testPrescriptionItems() {
		
		PrescriptionItem pItem = new PrescriptionItem();
		pItem.setSubtotal(2.2);
		prescription1.setTheItem(pItem);
		assertEquals(pItem,prescription1.getTheItem());
		
		PrescriptionItem pItem2 = new PrescriptionItem();
		ArrayList<PrescriptionItem> items = new ArrayList<PrescriptionItem>();
		items.add(pItem);
		
		pItem2.setSubtotal(2.4);
		prescription1.setTheItems(items);
		assertEquals(items,prescription1.getTheItems());
		
		//prescription1.addPrescriptionItem(pItem2);
		
	}
	
	@Test
	void testPrescriptionVideo() {
		Video vid = new Video("Yes","No");
		ArrayList<Video>videos = new ArrayList<Video>();
		prescription1.addVideo(vid);
		
	}
	
	
}
