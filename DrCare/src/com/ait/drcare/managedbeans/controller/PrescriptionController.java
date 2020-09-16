package com.ait.drcare.managedbeans.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
	
	private Prescription newPrescription;
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
	
		boolean exists = false;
		//Create new item
		PrescriptionItem newItem = new PrescriptionItem();
		//Set variables assigned
		newItem.setMedicine(prescriptionBean.getMedicine());
		newItem.setDosagePerDay(prescriptionBean.getDosage());
		newItem.setDuration(prescriptionBean.getDuration());
		
	
		
	
        //Check if item is already added
		for (PrescriptionItem prescriptionItem : prescriptionItems) {
			if (newItem.getMedicineName() == prescriptionItem.getMedicineName()) {
				System.out.println("Error, already added");
				exists = true;
				
				//Display error message
				FacesContext currentInstance = FacesContext.getCurrentInstance();
		        if(currentInstance != null) {
		            currentInstance.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Medicine is already in the prescription:", prescriptionItem.getMedicineName()));
		        }		
				return;
			}
		}
		//If not, add item to prescription
		if (exists == false) {
			prescriptionItems.add(newItem);
			prescriptionBean.setPrescriptionItems(prescriptionItems);
		}
	
		
	}
	
	
	
	public void addPrescription(PrescriptionBean prescriptionBean) {
		
		//set prescriptionitem
		
		newPrescription = new Prescription();
		
		//Set prescription variables
		newPrescription.setTheNote(prescriptionBean.getTheNote());
		newPrescription.setThePharmacist(prescriptionBean.getPharmacist());		
		newPrescription.setThePatient(doctorBean.getCurrentPatient());		
		newPrescription.setTheDoctor(doctorBean.getDoctor());		
		
		
		//test tems are there
		for (PrescriptionItem prescriptionItem : prescriptionItems) {
			newPrescription.addPrescriptionItem(prescriptionItem);;
		}
		dataStore.addPrescription(newPrescription);
	
		//Clear items for next prescription
		prescriptionItems.clear();
		
		//Close the dialog upon save
		PrimeFaces.current().dialog().closeDynamic(newPrescription);
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
