package com.ait.drcare.managedbeans.backing;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ait.drcare.model.Prescription;

@ManagedBean
@ViewScoped
public class PatientBean {
	public String name;
	public int id;
	public String email;
	public ArrayList<Prescription> prescriptions;
	public Prescription currentPrescription;
	
	public Prescription getCurrentPrescription() {
		return currentPrescription;
	}
	public void setCurrentPrescription(Prescription currentPrescription) {
		this.currentPrescription = currentPrescription;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Prescription> getPrescriptions() {
		return prescriptions;
	}
	public void setPrescriptions(ArrayList<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
}
