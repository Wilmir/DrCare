package com.ait.drcare.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Prescription {

	private String theName;
	private Date theDatePrescribed;
	private String theStatus;
	private ArrayList<PrescriptionItem> theItems;
	
	
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
		this.theDatePrescribed = new Date(2020, 6, 21);	
		this.theStatus = PRESCRIPTION_WAITING_PAYMENT;
		theCount++;
	}
	
	public Prescription(String name, Date datePrescribed)
	{
		this.theName = name;
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
	}

	public ArrayList<PrescriptionItem> getTheItems() {
		return theItems;
	}

	public void setTheMedicines(ArrayList<PrescriptionItem> theItems) {
		this.theItems = theItems;
	}
	
	
	
	
}
