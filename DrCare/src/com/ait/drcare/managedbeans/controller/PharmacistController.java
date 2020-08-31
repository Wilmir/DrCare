package com.ait.drcare.managedbeans.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Prescription;


@ManagedBean
@SessionScoped
public class PharmacistController {
	
	private String theUserName;
	private ArrayList<Prescription> prescriptions;
	private PrescriptionController pController;
	
	
	private UserListBean existingData;
	
	
	private ArrayList<Patient> patientSearch; //Patients user is searching for
	
	@PostConstruct
	public void init() {
		prescriptions = new ArrayList<Prescription>(); //insansiate 
		
		
		existingData = Helper.getBean("userListBean", UserListBean.class);
		prescriptions= existingData.getPrescriptions();
		
		
		Prescription prescription1 = new Prescription();
		Prescription prescription2 = new Prescription();
		Prescription prescription3 = new Prescription();
		Prescription prescription4 = new Prescription();
		Prescription prescription5 = new Prescription();
		
		
		prescriptions.add(prescription1);
		prescriptions.add(prescription2);
		prescriptions.add(prescription3);
		prescriptions.add(prescription4);
		prescriptions.add(prescription5); 
	}

	public String getTheUserName() {
		return theUserName;
	}

	public void setTheUserName(String theUserName) {
		this.theUserName = theUserName;
	}

	public ArrayList<Prescription> getPrescriptions() {
		
		//Foreach, find prescriptions assigned to this pharmacist
		return prescriptions;
	}

	public void setPrescriptions(ArrayList<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public ArrayList<Patient> getPatientSearch() {
		return patientSearch;
	}

	public void setPatientSearch(ArrayList<Patient> patientSearch) {
		this.patientSearch = patientSearch;
	}
	



			
}
