package com.ait.drcare;

import java.util.ArrayList;

public class Patient extends User{
	
	
	private String theMedicalCardNumber;
	private ArrayList<String> Allergies;
	private ArrayList<Prescription> Prescriptions;
	private Doctor gp;
	
	
	public Patient() {
		
	}


	public Patient(String name,String ID,String Password,String Email,
			ArrayList<String> Allergies,String medicalCard,String address)
	{
		super(name,ID,Password,Email,address);
		this.Allergies = Allergies;	
		this.theMedicalCardNumber = medicalCard;
	}


	public ArrayList<String> getAllergies() {
		return Allergies;
	}


	public void setAllergies(ArrayList<String> allergies) {
		Allergies = allergies;
	}


	public ArrayList<Prescription> getPrescriptions() {
		return Prescriptions;
	}


	public void setPrescriptions(ArrayList<Prescription> prescriptions) {
		Prescriptions = prescriptions;
	}


	public Doctor getGp() {
		return gp;
	}


	public void setGp(Doctor gp) {
		this.gp = gp;
	}


	public String getTheMedicalCardNumber() {
		return theMedicalCardNumber;
	}


	public void setTheMedicalCardNumber(String theMedicalCardNumber) {
		this.theMedicalCardNumber = theMedicalCardNumber;
	}
	
	
	
	
	
	
	
	
	
	
}