package com.ait.drcare.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Medicine {
	
	private int theID;
	private String theName;
	private String strength;
	private Date theExpiryDate;
	private ArrayList<String> theContents;
	private ArrayList<String> theSideEffects;
	private double theUnitPrice;
	
	
	public Medicine()
	{
		this.theID = (int) (Math.random()*(Integer.MAX_VALUE/10 - 1000000 + 1) + 1000000); // this has 1 trillionth chance of getting same ID for diff medicines;
		this.theContents = new ArrayList<String>();
		this.theSideEffects = new ArrayList<String>();
		this.theExpiryDate = getDateThreeYearsFromNow();

	}
		
	public Medicine(String name, String strength, double price) {
		this.theID = (int) (Math.random()*(Integer.MAX_VALUE/10 - 1000000 + 1) + 1000000); // this has 1 trillionth chance of getting same ID for diff medicines;
		this.theName = name;
		this.strength = strength;
		this.theUnitPrice = price;
		
		this.theContents = new ArrayList<String>();
		this.theSideEffects = new ArrayList<String>();
		
		this.theExpiryDate = getDateThreeYearsFromNow();
	}

	public int getTheID() {
		return theID;
	}

	public void setTheID(int theID) {
		this.theID = theID;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
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

	public Date getTheExpiryDate() {
		return theExpiryDate;
	}

	public void setTheExpiryDate(Date theExpiryDate) {
		this.theExpiryDate = theExpiryDate;
	}

	public double getTheUnitPrice() {
		return theUnitPrice;
	}

	public void setTheUnitPrice(double theUnitPrice) {
		this.theUnitPrice = theUnitPrice;
	}
	
	private Date getDateThreeYearsFromNow() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, 3); 
		
		Date threeYearsfromNow = c.getTime();
		
		return threeYearsfromNow;
	}

	@Override
	public String toString() {
		return theName;
	}


}