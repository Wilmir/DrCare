package com.ait.drcare.managedbeans.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Prescription;


@ManagedBean
@SessionScoped
public class PrescriptionController {
	
	
	private ArrayList<Prescription> prescriptions;
	
	
	//Change to prescriptionListBean later
	private UserListBean dataStore;
	
	@PostConstruct
	public void init() {
		prescriptions = new ArrayList<Prescription>(); //insansiate 
		
		
/*		Prescription prescription1 = new Prescription();
		Prescription prescription2 = new Prescription();
		Prescription prescription3 = new Prescription();
		Prescription prescription4 = new Prescription();
		Prescription prescription5 = new Prescription();
		
		
		prescriptions.add(prescription1);
		prescriptions.add(prescription2);
		prescriptions.add(prescription3);
		prescriptions.add(prescription4);
		prescriptions.add(prescription5); */
		
		dataStore = Helper.getBean("userListBean", UserListBean.class);
		prescriptions = dataStore.getPrescriptions();
		
		System.out.println(prescriptions.size());
		
	}
	
	// The method for displaying the Create Prescription modal
	public void createPrescription() {
		Map<String, Object> options  = new HashMap<String, Object>();
		options.put("resizable", false);
		options.put("height", "600");
		options.put("contentHeight", "600");
        PrimeFaces.current().dialog().openDynamic("prescriptionForm", options, null);
	}
	
	public ArrayList<Prescription> getPrescriptions() {
		return prescriptions;
	}
	
}
