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
	
	
	public void AddPatient(Patient aPatient){
		
		Patients.add(aPatient);	
	}

	public void RemovePatient(Patient aPatient) {
		Patients.remove(aPatient);
	}
	
	public void FindPatient(String Name) {
		
		Patient searchPatient = new Patient();
		for (Patient patient : Patients) {
			if (patient.getTheName() == Name) {
				searchPatient = patient;
			}
		}
		
		//Update to display/ trim down displayed list
		
	}
	
	public void DisplayPatient() {
		
		//Access Patient's toString
		
	}
	
	public void AccessAllergies(Patient aPatient) {
		
		
		ArrayList<String> patientAllergies = new ArrayList<String>();
		//Display on form a list of the allergies
	}
	
	public void CreatePrescription()
	{
		
	}

	public ArrayList<Patient> getPatients() {
		return Patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		Patients = patients;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}