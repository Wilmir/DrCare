package com.ait.drcare.managedbeans.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.managedbeans.backing.*;
import com.ait.drcare.model.*;


@ManagedBean
@SessionScoped
public class DoctorController {
	private Patient currentPatient;
	private Prescription currentPrescription;
	private ArrayList<Prescription> prescriptions;
	private UserListBean dataStore;
	private String patientName;
	private String patientEmail;
	private int patientID;
	private String patientAddress;
	private ArrayList<String> allergies;
	private Object placeholder;
	
	
	@PostConstruct
	public void init() {
		dataStore = Helper.getBean("userListBean", UserListBean.class);
		
		//get selected patient
		//Get selected patient's prescriptions
		//Get allergies
		
	}
	
	// show the Patient upon search
	public void show(Patient patient) {
		this.currentPatient = patient;
		this.allergies = patient.getAllergies();
		this.prescriptions = dataStore.getPrescriptions(patient);
	}

	// view prescription details 
	public void viewPrescriptionDetails(Prescription prescription) {
		this.currentPrescription = prescription;
	}

	public ArrayList<Prescription> getPrescriptions(){
		return prescriptions;
		
	}

	public ArrayList<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(ArrayList<String> allergies) {
		this.allergies = allergies;
	}

	public Patient getCurrentPatient() {
		return currentPatient;
	}

	public void setCurrentPatient(Patient currentPatient) {
		this.currentPatient = currentPatient;
	}

	public Object getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(Object placeholder) {
		this.placeholder = placeholder;
	}

	public Prescription getCurrentPrescription() {
		return currentPrescription;
	}

	public void setCurrentPrescription(Prescription currentPrescription) {
		this.currentPrescription = currentPrescription;
	}
	
}
