package com.ait.drcare.model;

import java.util.ArrayList;

public class Pharmacist extends User{

	
	//Orders currently assigned to be dispensed here
	private ArrayList<Prescription> orders;

	private Prescription accessor = new Prescription();
	
	public Pharmacist()
	{
		this.role = "Pharmacist";
		this.orders = new ArrayList<Prescription>();
	}
	
	public Pharmacist(String name, int ID, String password,
						String email,String address){
		//Send to parent class constructor
		super(name, ID, password, email,address,"Pharmacist");
		
		this.orders = new ArrayList<Prescription>();
	}

	

	public void AddOrder(Prescription order){
		orders.add(order);
		//Update display if needed
	}

	public String orderReadyForPickup(Prescription order) {
		
		order.setTheStatus(order.PRESCRIPTION_READY_FOR_PICKUP);
		return order.getTheStatus();
	}
	
	public String orderDispensed(Prescription order) {
		order.setTheStatus(order.PRESCRIPTION_DISPENSED);
		
		return order.getTheStatus();
	}
	
	


	public String removeOrder(Prescription order) {
		orders.remove(order);
		
		return null;
	}
	
	//Intended for use of database
	public void setOrders(ArrayList<Prescription> orders) {
		this.orders = orders;
	}
	
	public ArrayList<Prescription> getOrders() {
		return orders;
	}
	
}
