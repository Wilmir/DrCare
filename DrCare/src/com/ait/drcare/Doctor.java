package com.ait.drcare;

import java.util.ArrayList;

public class Doctor extends User{
	
	private ArrayList<String> Patients;
	private String phoneNumber;
	
	public Doctor()
	{
		
	}
	
	public Doctor(String name, String ID, String password,
					String email,String phoneNumber,String address){
		super(name, ID, password, email,address);
		this.phoneNumber = phoneNumber;
		
	}
	
	
	public void addPatient()
	{
		
	}

	public void removePatient() {
		
	}
	
	public void findPatient() {
		
	}
	
	public void disPlayPatient() {
		
	}
	
	public void accessAllergies() {
		
	}
	
	public void createPrescription()
	{
		
	}

	public ArrayList<String> getPatients() {
		return Patients;
	}

	public void setPatients(ArrayList<String> patients) {
		Patients = patients;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}