package com.ait.drcare.model;

import java.util.ArrayList;

public class Doctor extends User{
	
	private ArrayList<Patient> Patients;
	private String phoneNumber;
	
	public Doctor()
	{
		this.role = "Doctor";
	}
	
	public Doctor(String name, int ID, String password,
					String email,String phoneNumber,String address){
		
		super(name, ID, password, email,address,"Doctor");
		this.phoneNumber = phoneNumber;
		
	}
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getPatientCount() {
		
		return Patients.size();
	}
	
	public void addPatient(Patient newPatient) {
		
	}
	
	
}