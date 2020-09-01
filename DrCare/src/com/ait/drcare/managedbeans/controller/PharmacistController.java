package com.ait.drcare.managedbeans.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Prescription;
import com.ait.drcare.model.Pharmacist;

@ManagedBean
@SessionScoped
public class PharmacistController {
	
	private String theUserEmail;
	private ArrayList<Prescription> prescriptions;
	private ArrayList<Pharmacist> pharmacists;
	private PrescriptionController pController;
	
	
	private UserListBean dataStore;
	
	
	private ArrayList<Patient> patientSearch; //Patients user is searching for
	
	@PostConstruct
	public void init() {
		prescriptions = new ArrayList<Prescription>(); //insansiate 
		
		
		existingData = Helper.getBean("userListBean", UserListBean.class);
		
		theUserEmail = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		dataStore = Helper.getBean("userListBean", UserListBean.class);
		pharmacists = dataStore.getQualifiedPharmacistsLicenses()
		for (Patient patient : patients) {
			if (patient.getTheEmail().equals(userEmail)) {
				currentUser = patient;
			}
			break;
		}

		
		
		findPrescriptionOrders();
	}

	public String getTheUserEmail() {
		return theUserEmail;
	}

	public void setTheUserEmail(String theUserName) {
		this.theUserEmail = theUserName;
	}

	
	public void findPrescriptionOrders() {
		
		ArrayList<Prescription> orders = new ArrayList<Prescription>();
		
		String userEmail = "";
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		userEmail= (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get( "user");
		System.out.println(" User email is: " +userEmail);
		
		
		//Filter out prescriptions for this specific pharmacist user
		for (Prescription prescription : orders) {
			
			System.out.println(prescription.getThePharmacist().getTheName());
			
			if (prescription.getThePharmacist().getTheEmail() == userEmail) {
				System.out.println("yes");
			}
		}
		
	}
	
	public ArrayList<Prescription> getPrescriptions() {
		
		//Foreach, find prescriptions assigned to this pharmacist
		return prescriptions;
	}

	public void setPrescriptions(ArrayList<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	
	
	



			
}
