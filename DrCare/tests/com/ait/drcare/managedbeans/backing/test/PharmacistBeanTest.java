package com.ait.drcare.managedbeans.backing.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.managedbeans.backing.PharmacistBean;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Pharmacist;
import com.ait.drcare.model.Prescription;
import com.ait.drcare.model.User;
import com.ait.drcare.model.Video;

class PharmacistBeanTest {

	private PharmacistBean pharmacistBean;
	private UserListBean dataStore;
	
	
	//Elements of Pharmacist Bean cannot be tested
	//as it retreieves user at run time based on loged in user
	@BeforeEach
	public void setUp() {
		pharmacistBean = new PharmacistBean();
		dataStore = new UserListBean();
	}

	@Test
	void testSetCurrentUser() {
		// User(String name, int ID, String password,String email,String address, String role)
		Pharmacist pharmacist = new Pharmacist("Wilmir Nicanor", 30000001, "password", "wilmir@google.com", "Athlone, Ireland");
		
		pharmacistBean.setCurrentUser(pharmacist);
		
		assertEquals("wilmir@google.com", pharmacistBean.getCurrentUser().getTheEmail());	
	}
	
	@Test
	void testCurrentPrescriptionStatus() {
		Prescription prescription = new Prescription();
		prescription.setTheStatus(Prescription.PRESCRIPTION_READY_FOR_PICKUP);
		
		pharmacistBean.setCurrentPrescription(prescription);
		
		assertEquals("Ready for pickup", pharmacistBean.getCurrentPrescription().getTheStatus());
		assertTrue(pharmacistBean.isPreview());
		pharmacistBean.setPreview(false);
		assertFalse(pharmacistBean.isPreview());
		pharmacistBean.preview();
		assertTrue(pharmacistBean.isPreview());
	}
	
	@Test
	void testVideoRetreival() {
		Video v = new Video("Video", "whoop");
		pharmacistBean.setVideo(v);
		assertEquals(v,pharmacistBean.getVideo());
	}
	
	@Test
	void testPrescriptionSettersGetters() {
		Prescription prescription = new Prescription();
		Prescription prescription1 = new Prescription();
		ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
		prescriptions.add(prescription1);
		pharmacistBean.setPaidPrescriptions(prescriptions);
		
		assertEquals(prescriptions, pharmacistBean.getPaidPrescriptions());
		assertEquals(1,pharmacistBean.getQueueSize());
		pharmacistBean.setQueueSize(2);
		
		
	}
		
	
	
	@Test 
	void testVideosInPrescription() {
		Prescription prescription = new Prescription();
		Prescription prescription1 = new Prescription();
		ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
		prescriptions.add(prescription1);
		prescriptions.add(prescription);
		
		pharmacistBean.setPaidPrescriptions(prescriptions);
		Pharmacist pharmacist = new Pharmacist("Wilmir Nicanor", 30000001, "password", "wilmir@google.com", "Athlone, Ireland");
		pharmacistBean.setCurrentUser(pharmacist);
		
		

		Video v = new Video("Video", "whoop");
		prescription1.addVideo(v);
		pharmacistBean.setCurrentPrescription(prescription1);	
		assertEquals(1,pharmacistBean.getVideosCount());
		pharmacistBean.removeVideo(v);
		assertEquals(0,pharmacistBean.getVideosCount());

		pharmacistBean.setVideo(v);
		pharmacistBean.addVideo();
		
	}
	
}
