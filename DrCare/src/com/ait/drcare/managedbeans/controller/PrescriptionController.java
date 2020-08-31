package com.ait.drcare.managedbeans.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;


import com.ait.drcare.model.Prescription;


@ManagedBean
@SessionScoped
public class PrescriptionController {
	
	
	private ArrayList<Prescription> prescriptions;
	
	
	@PostConstruct
	public void init() {
		prescriptions = new ArrayList<Prescription>(); //insansiate 
		
		
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
	
	
	
	
	
	
}
