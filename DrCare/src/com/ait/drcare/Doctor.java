package com.ait.drcare;

import java.util.ArrayList;

public class Doctor extends User{
	
	private ArrayList<String> Patients;
	private String phoneNumber;
	
	public Doctor()
	{
		super("Doctor");
	}
	
	public Doctor(String name, String ID, String password,
					String email,String phoneNumber,String address){
		
		super(name, ID, password, email,address,"Doctor");
		this.phoneNumber = phoneNumber;
		
	}
	
	
	public void AddPatient()
	{
		
	}

	public void RemovePatient() {
		
	}
	
	public void FindPatient() {
		
	}
	
	public void DisplayPatient() {
		
	}
	
	public void AccessAllergies() {
		
	}
	
	public void CreatePrescription()
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