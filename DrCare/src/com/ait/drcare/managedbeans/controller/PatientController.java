package com.ait.drcare.managedbeans.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Patient;


@ManagedBean
@SessionScoped
public class PatientController {
	private int patientID;
	private ArrayList<Patient> patients;
	private UserListBean existingUsers;
	private ArrayList<Patient> patientSearch;
	
	@PostConstruct
	public void init() {
		existingUsers = Helper.getBean("userListBean", UserListBean.class);
		patients= existingUsers.getPatients();
	}
	
	

	public int getPatientID() {
		return patientID;
	}



	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}



	public ArrayList<Patient> getPatients() {
		return patients;
	}
	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	
	
	
	public void searchPatient() {
		
		for(int counter=0; counter<patients.size(); counter++) {
			if (patients.get(counter).getTheID() == this.patientID) {
				patientSearch.add(patients.get(counter));
			}
		}
}


	public ArrayList<Patient> getPatientSearch() {
		return patientSearch;
	}


	public void setPatientSearch(ArrayList<Patient> patientSearch) {
		this.patientSearch = patientSearch;
	}		
}
