package com.ait.drcare.managedbeans.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Medicine;
import com.ait.drcare.model.Patient;
import com.ait.drcare.model.Prescription;
import com.ait.drcare.model.PrescriptionItem;
import com.ait.drcare.model.Pharmacist;

@ManagedBean
@SessionScoped
public class PharmacistController {
	
	private Pharmacist currentUser;
	private String theUserEmail;
	private ArrayList<Prescription> prescriptions;
	private Medicine theMedicine;
	private PrescriptionItem theItem;
	
	private ArrayList<Pharmacist> pharmacists;
	private PrescriptionController pController;
	
	
	private UserListBean dataStore;
	
	
	private ArrayList<Patient> patientSearch; //Patients user is searching for
	
	@PostConstruct
	public void init() {
		prescriptions = new ArrayList<Prescription>(); //insansiate 
		
		//Get email from session
		theUserEmail = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		//Access the data, check users
		dataStore = Helper.getBean("userListBean", UserListBean.class);	
		
		pharmacists = dataStore.getPharmacists();
		prescriptions = dataStore.getPrescriptions();
		
		
		//find user in database
		for (Pharmacist pharmacist : pharmacists) {
			if (pharmacist.getTheEmail().equals(theUserEmail)) {
				currentUser = pharmacist;
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

	
	public void updateStatus(Prescription prescription) {
		prescription.setTheStatus("Dispensed");
	}
	
	//Find prescriptions tied to this user
	public void findPrescriptionOrders() {
		
	
		
		//Filter out prescriptions for this specific pharmacist user
		for (Prescription prescription : prescriptions) {
			
			System.out.println(prescription.getThePharmacist().getTheName());
			
			if (prescription.getThePharmacist().getTheEmail() == theUserEmail) {
				System.out.println("yes");
			}
		}
		
	}
	
	public String saveChanges() {
		for (Prescription prescription : prescriptions) {
			prescription.setCanEditNote(false);
		}	
		return null;
	}
	
	
	public ArrayList<Prescription> getPrescriptions() {
		
		//Foreach, find prescriptions assigned to this pharmacist
		return prescriptions;
	}

	public void setPrescriptions(ArrayList<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	
	
	//note
	public String getPrescriptionNote(Prescription prescription) {
		
		return prescription.getTheNote();
		
	}
	
	public boolean getPrescriptionEdit(Prescription prescription) {
		return prescription.isCanEditNote();
	}
	public String enableEditNote(Prescription prescription) {
		prescription.setCanEditNote(true);
		return null;
	}
	


			
}
