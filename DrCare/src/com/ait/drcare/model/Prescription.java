package com.ait.drcare.model;

import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Prescription {

	private String theName;
	private Date theDatePrescribed;
	
	
	private PrescriptionItem theItem;
	
	private String theStatus;
	private ArrayList<String> statusValues;
	
	private String theNote;
	private boolean CanEditNote;
	
	private Pharmacist thePharmacist;
	private Patient thePatient;
	
	private static int theCount;

	final String PRESCRIPTION_WAITING_PAYMENT = "Waiting for payment",
				 PRESCRIPTION_DISPENSED = "Order Dispenced",
				 PRESCRIPTION_READY_FOR_PICKUP = "Ready for pickup";
	
	
	public Prescription()
	{

		/*
		 placehold Variables 	 
		 */
		this.theName = "Name";
		this.theNote = "";
		this.theDatePrescribed = new Date(2020, 6, 21);	
		this.theStatus = PRESCRIPTION_WAITING_PAYMENT;
		this.statusValues = new ArrayList<String>();
		this.statusValues.add(PRESCRIPTION_WAITING_PAYMENT);
		this.statusValues.add(PRESCRIPTION_DISPENSED);
		this.statusValues.add(PRESCRIPTION_READY_FOR_PICKUP);
		this.CanEditNote = false;
		theCount++;
	}
	
	public Prescription(String name, Date datePrescribed)
	{
		this.theName = name;
		this.theNote = "";
		this.CanEditNote = false;
		this.theDatePrescribed = datePrescribed;		
		this.theStatus = PRESCRIPTION_WAITING_PAYMENT;
		
		theCount++;
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
	}

	public Patient getThePatient() {
		return thePatient;
	}

	public void setThePatient(Patient thePatient) {
		this.thePatient = thePatient;
		thePatient.addPrescription(this);
	}

	public PrescriptionItem getTheItem() {
		return theItem;
	}

	public void setTheItem(PrescriptionItem theItem) {
		this.theItem = theItem;
	}

	public ArrayList<String> getTheStatuses() {
		return statusValues;
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

	public void setStatusValues(ArrayList<String> statusValues) {
		this.statusValues = statusValues;
	}

	public boolean isCanEditNote() {
		return CanEditNote;
	}

	public void setCanEditNote(boolean canEditNote) {
		CanEditNote = canEditNote;
	}
	
	
	
	
}
