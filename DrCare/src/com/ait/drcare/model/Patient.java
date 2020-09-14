package com.ait.drcare.model;

import java.util.ArrayList;

public class Patient extends User{
	
	private String photo;
	private String theMedicalCardNumber;
	private ArrayList<String> Allergies;
	private Doctor gp;
		
	public Patient() {
		this.role = "Patient";
	}


	public Patient(String name,int ID,String Password,String Email,
			ArrayList<String> Allergies,String medicalCard,String address)
	{
	
		super(name,ID,Password,Email,address,"Patient");
		this.Allergies = Allergies;	
		this.theMedicalCardNumber = medicalCard;
	}


	public ArrayList<String> getAllergies() {
		return Allergies;
	}


	public void setAllergies(ArrayList<String> allergies) {
		Allergies = allergies;
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


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}	
	
	
}