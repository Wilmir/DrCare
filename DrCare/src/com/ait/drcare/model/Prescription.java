package com.ait.drcare.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Prescription {

	private String theName;
	private LocalDate theDatePrescribed;
	private String theStatus;
	private ArrayList<PrescriptionItem> theItems;
	
	
	private Pharmacist thePharmacist;
	private Patient thePatient;

	final String PRESCRIPTION_WAITING_PAYMENT = "Waiting for payment",
				 PRESCRIPTION_DISPENSED = "Order Dispenced",
				 PRESCRIPTION_READY_FOR_PICKUP = "Ready for pickup";
	
	
	public Prescription()
	{

		this.theStatus = PRESCRIPTION_WAITING_PAYMENT;
	}
	
	public Prescription(String name, LocalDate datePrescribed)
	{
		this.theName = name;
		this.theDatePrescribed = datePrescribed;		
		this.theStatus = PRESCRIPTION_WAITING_PAYMENT;
	}

	public String getTheName() {
		return theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}

	public LocalDate getTheDatePrescribed() {
		return theDatePrescribed;
	}

	public void setTheDatePrescribed(LocalDate theDatePrescribed) {
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
