package com.ait.drcare.managedbeans.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;

import org.primefaces.PrimeFaces;

import com.ait.drcare.helpers.Helper;
import com.ait.drcare.managedbeans.backing.DoctorBean;
import com.ait.drcare.managedbeans.backing.PrescriptionBean;
import com.ait.drcare.managedbeans.support.UserListBean;
import com.ait.drcare.model.Medicine;
import com.ait.drcare.model.Prescription;
import com.ait.drcare.model.PrescriptionItem;


@ManagedBean
@SessionScoped
public class PrescriptionController {
	
	
	private ArrayList<Prescription> prescriptions;
	private ArrayList<PrescriptionItem> prescriptionItems;
	private DoctorBean doctorBean;
	private DoctorController doctorController;
	
	//Change to prescriptionListBean later
	private UserListBean dataStore;
	
	@PostConstruct
	public void init() {
		prescriptions = new ArrayList<Prescription>(); //insansiate 
		prescriptionItems = new ArrayList<PrescriptionItem>();
		
		dataStore = Helper.getBean("userListBean", UserListBean.class);
		prescriptions = dataStore.getPrescriptions();
		
		doctorBean = Helper.getBean("doctorBean", DoctorBean.class);	
		doctorController = Helper.getBean("doctorController", DoctorController.class);	
		
		System.out.println(prescriptions.size());
	}
	
	public void addItem(PrescriptionBean prescriptionBean) {
	
		//Create new item
		PrescriptionItem newItem = new PrescriptionItem();
		//Set variables assigned
		newItem.setMedicine(prescriptionBean.getMedicine());
		newItem.setDosagePerDay(prescriptionBean.getDosage());
		newItem.setDuration(prescriptionBean.getDuration());
		
		//add to the list
		prescriptionItems.add(newItem);
		prescriptionBean.setPrescriptionItems(prescriptionItems);
		
		//Update so form displays it
		
	}
	
	
	
	public void addPrescription(PrescriptionBean prescriptionBean) {
		
		//set prescriptionitem
		
		Prescription prescription = new Prescription();
		
		//Set prescription variables
		prescription.setTheNote(prescriptionBean.getTheNote());
		prescription.setThePharmacist(prescriptionBean.getPharmacist());		
		prescription.setThePatient(doctorBean.getCurrentPatient());		
		prescription.setTheDoctor(doctorBean.getDoctor());		
		prescription.setTheItems(prescriptionItems);
		
		dataStore.addPrescription(prescription);
	
		//Clear items for next prescription
		prescriptionItems.clear();
		
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
