package com.ait.drcare.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Medicine {
	
	private String theName;
	private LocalDate theExpiryDate;
	private ArrayList<String> theContents;
	private ArrayList<String> theSideEffects;
	
	
	public Medicine()
	{
		this.theContents = new ArrayList<String>();
		this.theSideEffects = new ArrayList<String>();
	}
	
	public Medicine(String name,LocalDate expiryDate) {
		this.theName = name;
		this.theContents = new ArrayList<String>();
		this.theSideEffects = new ArrayList<String>();
		this.theExpiryDate = expiryDate;
	}

	public String getTheName() {
		return theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}

	public ArrayList<String> getTheContents() {
		return theContents;
	}

	public void setTheContents(ArrayList<String> theContents) {
		this.theContents = theContents;
	}

	public ArrayList<String> getTheSideEffects() {
		return theSideEffects;
	}

	public void setTheSideEffects(ArrayList<String> theSideEffects) {
		this.theSideEffects = theSideEffects;
	}

	public LocalDate getTheExpiryDate() {
		return theExpiryDate;
	}

	public void setTheExpiryDate(LocalDate theExpiracyDate) {
		this.theExpiryDate = theExpiracyDate;
	}
	
	
	
}