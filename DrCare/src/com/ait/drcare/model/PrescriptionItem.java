package com.ait.drcare.model;

public class PrescriptionItem {

	private Medicine theMedicine;
	private double dosagePerDay;
	private int duration;
	private  int quantity;
	private double subtotal;
	
	public PrescriptionItem() {
		
	}
	
	public PrescriptionItem(Medicine aMedicine, double aDosagePerDay,
			int aDuration, int aQuantity) {
		this.theMedicine = aMedicine;
		this.dosagePerDay = aDosagePerDay;
		this.duration = aDuration;
		this.quantity = aQuantity;
		
		
	}

	public Medicine getMedicine() {
		return theMedicine;
	}

	public void setMedicine(Medicine aMedicine) {
		this.theMedicine = aMedicine;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDosagePerDay() {
		return dosagePerDay;
	}

	public int getDuration() {
		return duration;
	}

	public double getSubtotal() {
		return subtotal;
	}
	
	
	
}



