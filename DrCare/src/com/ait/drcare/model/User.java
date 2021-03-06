package com.ait.drcare.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class User
{
	protected String theName;
	protected int theID;
	protected String thePassword;
	protected String theEmail;
	protected String theAddress;
	protected String role;
	protected boolean accountLock = false;
	boolean canEdit;
	protected int failedAttempts = 0;
	protected ArrayList<Prescription> prescriptions;
	
	public User()
	{
		
	}
	
	public User(String name, int ID, String password,String email,String address, String role)
	{
		this.theName = name;
		this.theID = ID;
		this.thePassword = password;
		this.theEmail = email;
		this.theAddress = address;
		this.role = role;
	}

	public String getTheName() {
		return theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}

	public int getTheID() {
		return theID;
	}

	public void setTheID(int theID) {
		this.theID = theID;
	}

	public String getThePassword() {
		return thePassword;
	}

	public void setThePassword(String thePassword) {
		this.thePassword = thePassword;
	}

	public String getTheEmail() {
		return theEmail;
	}

	public void setTheEmail(String theEmail) {
		this.theEmail = theEmail;
	}
	
	public String getTheAddress() {
		return theAddress;
	}

	public void setTheAddress(String address) {
		this.theAddress = address;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean getAccountLock() {
		return accountLock;
	}

	public void setAccountLock(boolean lock) {
		this.accountLock = lock;
	}
	
	public int getFailedAttempts() {
		return failedAttempts;
	}

	public void setFailedAttempts() {
		this.failedAttempts++;
	}

	public void resetFailedAttempts() {
		failedAttempts=0;
	}
	
	public boolean isCanEdit() {
		return canEdit;
	}
	
	public void setCanEdit(boolean canEdit) {
		this.canEdit= canEdit;
	}


	public ArrayList<Prescription> getPrescriptions() {
		// sort the prescription from latest to old if the user is a Patient or a Doctor
		if(prescriptions != null && !(this instanceof Pharmacist)) {
			Collections.sort(prescriptions, new Comparator<Prescription>(){

				@Override
				public int compare(Prescription p1, Prescription p2) {
					return (p2.getTheDatePrescribed()).compareTo(p1.getTheDatePrescribed());
				}
				
			});
		}
		
		// sort from oldest to new if the user is a Pharmacist
		if(prescriptions != null && (this instanceof Pharmacist)) {
			Collections.sort(prescriptions, new Comparator<Prescription>(){

				@Override
				public int compare(Prescription p1, Prescription p2) {
					return (p1.getTheDatePrescribed()).compareTo(p2.getTheDatePrescribed());
				}
				
			});
		}
		
		return prescriptions;
	}


	public void setPrescriptions(ArrayList<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	public void addPrescription(Prescription prescription) {
		if(prescriptions == null) {
			prescriptions = new ArrayList<>();
		}
		
		prescriptions.add(prescription);
	}
	
	@Override
	public String toString() {
		return "User [theName=" + theName + ", theID=" + theID + ", thePassword=" + thePassword + ", theEmail="
				+ theEmail + ", theAddress=" + theAddress + ", role=" + role + "]";
		
	}

}
