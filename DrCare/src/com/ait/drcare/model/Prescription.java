package com.ait.drcare.model;

import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Prescription {
	private String theName;
	private Date theDatePrescribed;
	
	private String theStatus;
	private ArrayList<String> statusValues;
	
	private String theNote;
	private boolean CanEditNote;
	
	private Pharmacist thePharmacist;
	private Patient thePatient;
	private Doctor theDoctor;
	
	
	private PrescriptionItem theItem; // this will need to be removed, keeping this so as not to break code I am not aware of
	private ArrayList<PrescriptionItem> theItems;
	private ArrayList<Video> videos;
	
	private double total;
	

	public final static String PRESCRIPTION_WAITING_PAYMENT = "Waiting for payment",
				 PRESCRIPTION_DISPENSED = "Order Dispensed",
				 PRESCRIPTION_READY_FOR_PICKUP = "Ready for pickup";
	
	
	public Prescription()
	{
		this.theName = "Rx" +  (int) (Math.random()*(Integer.MAX_VALUE/10 - 1000000 + 1) + 1000000);
		this.theNote = "";
		this.theDatePrescribed = new Date();
		this.theStatus = PRESCRIPTION_WAITING_PAYMENT;
		this.statusValues = new ArrayList<String>();
		this.statusValues.add(PRESCRIPTION_WAITING_PAYMENT);
		this.statusValues.add(PRESCRIPTION_DISPENSED);
		this.statusValues.add(PRESCRIPTION_READY_FOR_PICKUP);
	}
	
	
	public Prescription(Patient patient, Pharmacist pharmacist, Doctor doctor) {
		this();
		
		this.thePatient = patient;
		this.thePharmacist = pharmacist;
		this.theDoctor = doctor;
		
		thePatient.addPrescription(this);
		thePharmacist.addPrescription(this);
		theDoctor.addPrescription(this);
	}

	
	public String getTheName() {
		return theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}

	public Date getTheDatePrescribed() {
		return theDatePrescribed;
	}

	public void setTheDatePrescribed(Date theDatePrescribed) {
		this.theDatePrescribed = theDatePrescribed;
	}

	public String getTheStatus() {
		return theStatus;
	}

	public void setTheStatus(String theStatus) {
		this.theStatus = theStatus;
	}

	public Pharmacist getThePharmacist() {
		return thePharmacist;
	}

	public void setThePharmacist(Pharmacist thePharmacist) {
		this.thePharmacist = thePharmacist;
		thePharmacist.addPrescription(this);		
	}

	public Patient getThePatient() {
		return thePatient;
	}

	public void setThePatient(Patient thePatient) {
		this.thePatient = thePatient;
		thePatient.addPrescription(this);
	}

	

	public String getTheNote() {
		return theNote;
	}

	public void setTheNote(String theNote) {
		this.theNote = theNote;
	}

	public ArrayList<String> getStatusValues() {
		return statusValues;
	}
	public ArrayList<String> getTheStatuses() {
		return statusValues;
	}
	
	

	public boolean isCanEditNote() {
		return CanEditNote;
	}

	public void setCanEditNote(boolean canEditNote) {
		CanEditNote = canEditNote;
	}

	public Doctor getTheDoctor() {
		return theDoctor;
	}

	public void setTheDoctor(Doctor theDoctor) {
		this.theDoctor = theDoctor;
		theDoctor.addPrescription(this);
	}

	public PrescriptionItem getTheItem() {
		return theItem;
	}

	public void setTheItem(PrescriptionItem theItem) {
		this.theItem = theItem;
	}

	public ArrayList<PrescriptionItem> getTheItems() {
		return theItems;
	}

	public void setTheItems(ArrayList<PrescriptionItem> theItems) {
		this.theItems = theItems;
	}
	
	public void addPrescriptionItem(PrescriptionItem item) {
		if(theItems == null) {
			theItems = new ArrayList<>();
		}
		
		theItems.add(item);
		total += item.getSubtotal();
	}
	
	public ArrayList<Video> getVideos() {
		return videos;
	}


	public void setVideos(ArrayList<Video> videos) {
		this.videos = videos;
	}

	public void addVideo(Video video) {
		if(videos == null) {
			videos = new ArrayList<>();
		}
		
		videos.add(video);
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
		
}
