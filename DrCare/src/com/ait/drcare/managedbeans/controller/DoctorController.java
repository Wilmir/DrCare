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
	}
	
	public void show(Patient patient) {
		this.currentPatient = patient;
		this.allergies = patient.getAllergies();
	}

	
	public ArrayList<String> getAllergies() {
		System.out.println(allergies);
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

	
	
	
}
