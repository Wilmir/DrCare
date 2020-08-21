package com.ait.drcare;

import java.sql.Date;
import java.util.ArrayList;

public class Prescription {

	private String theName;
	private Date theDatePrescribed;
	private ArrayList<String> theContents;
	private ArrayList<String> theSideEffects;
	private String theStatus;
	
	final String PRESCRIPTION_WAITING_PAYMENT = "Waiting for payment",
				 PRESCRIPTION_DISPENSED = "Order Dispenced",
				 PRESCRIPTION_READY_FOR_PICKUP = "Ready for pickup";
	
	
	public Prescription()
	{
		this.theContents = new ArrayList<String>();
		this.theSideEffects = new ArrayList<String>();
		this.theStatus = "Not paid";
	}
	
	public Prescription(String name, Date datePrescribed)
	{
		this.theName = name;
		this.theDatePrescribed = datePrescribed;		
		this.theContents = new ArrayList<String>();
		this.theSideEffects = new ArrayList<String>();
		this.theStatus = PRESCRIPTION_WAITING_PAYMENT;
	}
	
	
	
	
}
