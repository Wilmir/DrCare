package com.ait.drcare.managedbeans.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.model.Prescription;
import com.ait.drcare.model.Video;

class PrescriptionTest {

	private Prescription prescription1;
	private Prescription prescription2 = new Prescription();
	
	@BeforeEach
	void setUp() throws Exception {
	prescription1 = new Prescription();
	
	}

	@Test
	void testConstructors() {
		
		assertEquals("", prescription2.getTheNote());
		assertEquals("Waiting for payment",prescription2.getTheStatus());
		assertEquals("Waiting for payment",prescription2.getTheStatus());
		assertEquals(3,prescription2.getStatusValues().size());
		assertEquals("Waiting for payment",prescription2.getTheStatus());
		assertFalse(prescription2.isCanEditNote());
		
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

	}
}
