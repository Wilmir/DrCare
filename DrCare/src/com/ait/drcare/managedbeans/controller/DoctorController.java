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
	
	private Object placeholder;
	
	
	@PostConstruct
	public void init() {
		dataStore = Helper.getBean("userListBean", UserListBean.class);
	}
	
	public void show(Patient patient) {
		this.currentPatient = patient;
		this.patientName = patient.getTheName();
		this.patientEmail = patient.getTheEmail();
		this.patientID = patient.getTheID();
		this.patientAddress = patient.getTheAddress();
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public Patient getCurrentPatient() {
		return currentPatient;
	}

	public void setCurrentPatient(Patient currentPatient) {
		this.currentPatient = currentPatient;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public Object getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(Object placeholder) {
		this.placeholder = placeholder;
	}

	
	
	
}
