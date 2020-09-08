package com.ait.drcare.managedbeans.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.backing.PrescriptionBean;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Medicine;
import com.ait.drcare.model.Prescription;
import com.ait.drcare.model.PrescriptionItem;


@ManagedBean
@SessionScoped
public class PrescriptionController {
	
	
	private ArrayList<Prescription> prescriptions;
	private DoctorController currentDoctor;
	
	//Change to prescriptionListBean later
	private UserListBean dataStore;
	
	@PostConstruct
	public void init() {
		prescriptions = new ArrayList<Prescription>(); //insansiate 
		
		
		
		dataStore = Helper.getBean("userListBean", UserListBean.class);
		prescriptions = dataStore.getPrescriptions();
		
		
		currentDoctor = Helper.getBean("doctorController", DoctorController.class);	
		
		System.out.println(prescriptions.size());
		
	}
	
	
	public String addPrescription(PrescriptionBean prescriptionBean) {
		
		
		
		//set prescriptionitem
		System.out.println("PrescriptionController test");
		Prescription prescription = new Prescription();
		PrescriptionItem pItem = new PrescriptionItem();
	
		
		
		
		pItem.setMedicine(prescriptionBean.getMedicine());
		pItem.setDosagePerDay(prescriptionBean.getDosage());
		pItem.setDuration(prescriptionBean.getDuration());
		
		
		
		prescription.setTheNote(prescriptionBean.getTheNote());
		prescription.setThePharmacist(prescriptionBean.getPharmacist());
		System.out.println(prescriptionBean.getPharmacist().getTheEmail()); // works
		
		prescription.setThePatient(currentDoctor.getCurrentPatient());
		System.out.println(prescriptionBean.getPatient().getTheName()); // showing null
		
		
		//Test activation
		System.out.println("PrescriptionController test end");
		
		dataStore.addPrescription(prescription);
	
		return null;
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
	
	public void testPrep() {
		System.out.println("howdy");
	}
	
	
}
