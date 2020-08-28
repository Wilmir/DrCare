package com.ait.drcare.model;

import java.util.ArrayList;

public class Pharmacist extends User{

	
	//Orders currently assigned to be dispensed here
	private ArrayList<Prescription> orders;

	
	
	public Pharmacist()
	{
		this.role = "Pharmacist";
	}
	
	public Pharmacist(String name, int ID, String password,
						String email,String address){
		//Send to parent class constructor
		super(name, ID, password, email,address,"Pharmacist");
		
	}

	public ArrayList<Prescription> getOrders() {
		return orders;
	}

	public void AddOrder(Prescription order){
		orders.add(order);
		//Update display if needed
	}

	public void UpdateOrder(Prescription order) {
		
		
		
		
	}
	
	public void DispenseOrder() {
		//Get order, change status to DISPENSED
		
	}

	//Intended for use of database
	public void setOrders(ArrayList<Prescription> orders) {
		this.orders = orders;
	}
	
	
}
