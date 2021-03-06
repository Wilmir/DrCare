package com.ait.drcare.model;

public class PrescriptionItem {

	public Medicine theMedicine;
	private double dosagePerDay;
	private int duration;
	private  int quantity;
	private double subtotal;
	private String notefromPharmacist;
	
	
	public PrescriptionItem() {
		
	}
	
	public PrescriptionItem(Medicine aMedicine, double aDosagePerDay,int aDuration) {
		this.theMedicine = aMedicine;
		this.dosagePerDay = aDosagePerDay;
		this.duration = aDuration;		
	}

	public String getMedicineName() {
		return theMedicine.getTheName();
	}
	public Medicine getMedicine() {
		return theMedicine;
	}

	public void setMedicine(Medicine aMedicine) {
		this.theMedicine = aMedicine;
	}

	public int getQuantity() {
		quantity = (int) (Math.ceil(dosagePerDay * duration));
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDosagePerDay() {
		return dosagePerDay;
	}

	
	public void setDosagePerDay(double dosagePerDay) {
		this.dosagePerDay = dosagePerDay;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getDuration() {
		return duration;
	}

	public String getNotefromPharmacist() {
		return notefromPharmacist;
	}

	public void setNotefromPharmacist(String notefromPharmacist) {
		this.notefromPharmacist = notefromPharmacist;
	}

	public double getSubtotal() {
		subtotal = theMedicine.getTheUnitPrice() * getQuantity();
		return subtotal;
	}
	
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}



