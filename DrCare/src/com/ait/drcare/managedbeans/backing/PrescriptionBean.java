package com.ait.drcare.managedbeans.backing;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ait.drcare.model.Medicine;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Pharmacist;
import com.ait.drcare.model.Prescription;
import com.ait.drcare.model.PrescriptionItem;

@ManagedBean
@ViewScoped
public class PrescriptionBean {

	// This variable is only used as a placeholder when developing the frontEnd
	// Remove this and its getters and setters once you are done developing the PrescriptionBean
	private ArrayList<PrescriptionItem>  prescriptionItems = new ArrayList<PrescriptionItem>();
	
	private Patient patient = new Patient();
	private Pharmacist pharmacist = new Pharmacist();
	
	//PrescriptionItem Variables
	private Medicine medicine = new Medicine();
	private double dosage = 0;
	private int duration = 0;
	private int quantity = 0;
	private String theNote = "";

	private Object placeholder;


	//when adding new prescription, use this bean
	
	
	public void doTheThing() {
	System.out.println("did a thing");
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
		
	public Pharmacist getPharmacist() {
		return pharmacist;
	}
	public void setPharmacist(Pharmacist pharmacist) {
		this.pharmacist = pharmacist;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public double getDosage() {
		return dosage;
	}

	public void setDosage(double dosage) {
		this.dosage = dosage;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getTheNote() {
		return theNote;
	}

	public void setTheNote(String theNote) {
		this.theNote = theNote;
	}

	public Object getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(Object placeholder) {
		this.placeholder = placeholder;
	}
	
	
	
	
}
