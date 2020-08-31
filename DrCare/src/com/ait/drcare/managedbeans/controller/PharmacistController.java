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
		
		

		
		
		findPrescriptionOrders();
	}

	public String getTheUserName() {
		return theUserName;
	}

	public void setTheUserName(String theUserName) {
		this.theUserName = theUserName;
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
